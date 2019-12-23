package com.spbt.service.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
@Configuration
@EnableCaching
public class RedisDataSourceImpl implements RedisDataSource {

	private static final Logger log = LoggerFactory.getLogger(RedisDataSourceImpl.class);

	private static JedisPoolConfig config;
	private static JedisPool pool;
	
	@Value("${spring.redis.host}")
	private static String host;
	
	@Value("${spring.redis.password}")
	private static String password;
	
	@Value("${spring.redis.prot}")
	private static int prot;

	static {
		config = new JedisPoolConfig();
		// 最大空闲连接数
		config.setMaxIdle(200);
		// 最大连接数
		config.setMaxTotal(300);
		config.setTestOnBorrow(false);
		config.setTestOnReturn(false);
		pool = new JedisPool(config, host, prot, 3000, password);
	}

	@Override
	public Jedis getRedisObj() {
		try {
			Jedis jedisObj = pool.getResource();
			return jedisObj;
		} catch (Exception e) {
			log.error("GET REDISOBJ ERROR", e);
		}
		return null;
	}

	@Override
	public void returnResource(Jedis jedisObj) {
		try {
			jedisObj = pool.getResource();
		} finally {
			if (jedisObj != null) {
				jedisObj.close();
			}
		}
	}

	@Override
	public void returnResource(Jedis jedisObj, boolean broken) {
		if (broken) {
			jedisObj.close();
		} else {
			try {
				jedisObj = pool.getResource();
			} finally {
				if (jedisObj != null) {
					jedisObj.close();
				}
			}
		}
	}
}
