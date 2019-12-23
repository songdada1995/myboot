package com.spbt.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import com.spbt.core.Mapper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Mybatis数据源配置
 * @Author songbo
 * @Date 2019/12/10 16:46
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = MybatisDb2Config.SCAN_PACKAGE, sqlSessionFactoryRef = MybatisDb2Config.BEAN_SQL_SESSION_FACTORY_NAME)
public class MybatisDb2Config {

    /* 多数据原配置 - 修改开始 */
    public static final String SCAN_PACKAGE = "com.spbt.mapper.db2";
    public static final String MAPPER_LOCATION = "classpath*:mapper/db2/*.xml";
    static final String DATA_SOURCE_PROPERTIES_PREFIX = "spring.datasource.db2";
    static final String BEAN_NAME_PREFIX = "db2";
    static final String ENTITY_PACKAGE = "com.spbt.entity.db2";
    /* 多数据原配置 - 修改结束 */

    static final String BEAN_SQL_SESSION_FACTORY_NAME = BEAN_NAME_PREFIX + "SqlSessionFactory";
    static final String BEAN_DATA_SOURCE_NAME = BEAN_NAME_PREFIX + "DataSource";
    static final String BEAN_TRANSACTION_MANAGER_NAME = BEAN_NAME_PREFIX + "TransactionManager";
    static final String BEAN_TEST_SQL_SESSION_TEMPLATE_NAME = BEAN_NAME_PREFIX + "SqlSessionTemplate";
    static final String BEAN_MAPPER_HELPER_NAME = BEAN_NAME_PREFIX + "MapperHelper";

    @Bean(name = BEAN_DATA_SOURCE_NAME)
    @ConfigurationProperties(prefix = DATA_SOURCE_PROPERTIES_PREFIX)
    public DruidDataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDefaultReadOnly(false);
        return druidDataSource;
    }

    @Bean(name = BEAN_TRANSACTION_MANAGER_NAME)
    public DataSourceTransactionManager transactionManager(@Qualifier(value = BEAN_DATA_SOURCE_NAME) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = BEAN_SQL_SESSION_FACTORY_NAME)
    public SqlSessionFactory sqlSessionFactory(@Qualifier(value = BEAN_DATA_SOURCE_NAME) DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        //设置mapper location
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        sessionFactory.setTypeAliasesPackage(MybatisDb2Config.ENTITY_PACKAGE);

        //分页插件，更多详细配置见: https://pagehelper.github.io/docs/howtouse/
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");   //方言
        pageInterceptor.setProperties(properties);

        //添加插件
        sessionFactory.setPlugins(new Interceptor[]{pageInterceptor});

        return sessionFactory.getObject();
    }

    @Bean(name = BEAN_TEST_SQL_SESSION_TEMPLATE_NAME)
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier(value = BEAN_SQL_SESSION_FACTORY_NAME) SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * Mybatis 通用Mapper配置
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = BEAN_MAPPER_HELPER_NAME)
    public MapperHelper mapperHelper(@Qualifier(value = BEAN_SQL_SESSION_FACTORY_NAME) SqlSessionFactory sqlSessionFactory) {
        MapperHelper mapperHelper = new MapperHelper();
        //特殊配置
        Config config = new Config();
        config.setNotEmpty(false);
        config.setIDENTITY("MYSQL");
        //更多详细配置: http://git.oschina.net/free/Mapper/blob/master/wiki/mapper3/2.Integration.md

        mapperHelper.setConfig(config);
        mapperHelper.registerMapper(Mapper.class);
        mapperHelper.processConfiguration(sqlSessionFactory.getConfiguration());

        return mapperHelper;
    }



}
