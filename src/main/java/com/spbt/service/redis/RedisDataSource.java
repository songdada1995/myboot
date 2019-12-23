package com.spbt.service.redis;

import redis.clients.jedis.Jedis;

public interface RedisDataSource {

	public abstract Jedis getRedisObj();

	public void returnResource(Jedis jedisObj);

	public void returnResource(Jedis jedisObj, boolean broken);
	
}
