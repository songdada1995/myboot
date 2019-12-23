package com.spbt.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/static/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/static/img/**").addResourceLocations("classpath:/static/img/");
        registry.addResourceHandler("/static/public/**").addResourceLocations("classpath:/static/public/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    }


    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // setUseSuffixPatternMatch : 设置是否是后缀模式匹配，如“/user”是否匹配/user.*，默认true即匹配；
        // setUseTrailingSlashMatch : 设置路径后是否包含/，如“/user”是否匹配“/user/”，默认true即匹配；
        // configurer.setUseSuffixPatternMatch(false);
        // configurer.setUseTrailingSlashMatch(false);
        /**
         * 配置后置模式匹配是否仅在配置内容协商中明确指定的路径扩展名称时生效
         * 举个例子：假设WebMvcConfigurer中覆盖了configureContentNegotiation方法进行以下处理：
         * @Override
         * public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
         *     configurer.mediaType("pdf", MediaType.APPLICATION_PDF);
         *}
         * 当setUseRegisteredSuffixPatternMatch配置成TRUE时，即使setUseSuffixPatternMatch设置成True，
         * 在访问/test.do时也不会命中被RequestMapping注解值为/test的Controller；
         * 只有在访问/test.pdf时才能正常访问，其它任何的/test.txt或者/test.doc等均会报404；
         * 默认情况下该值是False
         */
        configurer.setUseRegisteredSuffixPatternMatch(true);
    }

    /**
     * 设置匹配*.do后缀请求
     * @param dispatcherServlet
     * @return
     */
    @SuppressWarnings("rawtypes")
	@Bean
    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {

        ServletRegistrationBean<DispatcherServlet> registrationBean = new ServletRegistrationBean<>(dispatcherServlet);
        registrationBean.addUrlMappings("*.htm");
        // 如果不设置name，则默认为“dispatcherServlet”。而spring boot提供的DispatcherServlet的name就是“dispatcherServlet”
        // 后注册的会覆盖掉name相同的ServletRegistrationBean，覆盖默认的dispatcherServlet
        registrationBean.setLoadOnStartup(1);
        registrationBean.setName("match");
        return registrationBean;
    }

    /**
     * 视图解析
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }
    
    /**
     * 映射跳转
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/db1/index");
    }
}