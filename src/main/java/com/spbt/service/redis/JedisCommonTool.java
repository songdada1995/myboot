package com.spbt.service.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spbt.constant.CommonConstants;
import com.spbt.utils.GsonUtil;

import redis.clients.jedis.Jedis;

@Service
public class JedisCommonTool {

	private static final Logger log = LoggerFactory.getLogger(JedisCommonTool.class);

	@Autowired
	private RedisDataSource redisDataSource;

	/**
	 * 存储内容
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public String set(String key, Object value) {
		Jedis redisObj = redisDataSource.getRedisObj();
		String result = null;
		if (null == redisObj) {
			return result;
		}
		boolean broken = false;
		try {
			String valueStr = GsonUtil.gsonString(value);
			result = redisObj.set(key, valueStr);
		} catch (Exception e) {
			log.error("REDIS SET ERROR", e);
			broken = true;
		} finally {
			redisDataSource.returnResource(redisObj, broken);
		}
		return result;
	}
	
	
	/**
	 * 存储用户信息
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public String setUser(String key, Object value) {
		Jedis redisObj = redisDataSource.getRedisObj();
		String result = null;
		if (null == redisObj) {
			return result;
		}
		boolean broken = false;
		try {
			String valueStr = GsonUtil.gsonString(value);
			result = redisObj.set(CommonConstants.WEB_USER+":"+key, valueStr);
		} catch (Exception e) {
			log.error("REDIS SET ERROR", e);
			broken = true;
		} finally {
			redisDataSource.returnResource(redisObj, broken);
		}
		return result;
	}
	
	/**
	 * 设置key 用户user 的过期时�?
	 * @param key
	 * @param seconds
	 * @return
	 */
	public Long expire(String key, int seconds) {
		Jedis redisObj = redisDataSource.getRedisObj();
		Long result = null;
		if (null == redisObj) {
			return result;
		}
		boolean broken = false;
		try {
			result = redisObj.expire(CommonConstants.WEB_USER+":"+key, seconds);
		} catch (Exception e) {
			log.error("REDIS SET ERROR", e);
			broken = true;
		} finally {
			redisDataSource.returnResource(redisObj, broken);
		}
		return result;
	}
	
	/**
	 * 设置key 的过期时�?
	 * @param key
	 * @param seconds
	 * @return
	 */
	public Long setTime(String key, int seconds) {
		Jedis redisObj = redisDataSource.getRedisObj();
		Long result = null;
		if (null == redisObj) {
			return result;
		}
		boolean broken = false;
		try {
			result = redisObj.expire(key, seconds);
		} catch (Exception e) {
			log.error("REDIS SET ERROR", e);
			broken = true;
		} finally {
			redisDataSource.returnResource(redisObj, broken);
		}
		return result;
	}
	
	/**
	 * 判断key是否存在
	 * @param key
	 * @return
	 */
	public Boolean exists(String key) {
		Jedis redisObj = redisDataSource.getRedisObj();
		Boolean result = false;
		if (null == redisObj) {
			return result;
		}
		boolean broken = false;
		try {
			 result = redisObj.exists(CommonConstants.WEB_USER+":"+key);
		} catch (Exception e) {
			log.error("REDIS SET ERROR", e);
			broken = true;
		} finally {
			redisDataSource.returnResource(redisObj, broken);
		}
		return result;
	}
	
	/**
	 * 判断key是否存在
	 * @param key
	 * @return
	 */
	public Boolean existsCommon(String key) {
		Jedis redisObj = redisDataSource.getRedisObj();
		Boolean result = false;
		if (null == redisObj) {
			return result;
		}
		boolean broken = false;
		try {
			 result = redisObj.exists(key);
		} catch (Exception e) {
			log.error("REDIS SET ERROR", e);
			broken = true;
		} finally {
			redisDataSource.returnResource(redisObj, broken);
		}
		return result;
	}
	
	/**
	 * 存储内容字符�?
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public String setStr(String key, String value) {
		Jedis redisObj = redisDataSource.getRedisObj();
		String result = null;
		if (null == redisObj) {
			return result;
		}
		boolean broken = false;
		try {
			result = redisObj.set(key, value);
		} catch (Exception e) {
			log.error("REDIS SET ERROR", e);
			broken = true;
		} finally {
			redisDataSource.returnResource(redisObj, broken);
		}
		return result;
	}

	/**
	 * get storage information
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key) {
		String result = null;
		Jedis redisObj = redisDataSource.getRedisObj();
		if (redisObj == null) {
			return result;
		}

		boolean broken = false;
		try {
			result = redisObj.get(key);

		} catch (Exception e) {
			log.error("REDIS GET METHOD ERROR", e);
			broken = true;
		} finally {
			redisDataSource.returnResource(redisObj, broken);
		}
		return result;
	}

	/**
	 * get storage information
	 * 
	 * @param key
	 * @return
	 */
	public String getUser(String key) {
		String result = null;
		Jedis redisObj = redisDataSource.getRedisObj();
		if (redisObj == null) {
			return result;
		}

		boolean broken = false;
		try {
			result = redisObj.get(CommonConstants.WEB_USER+":"+key);

		} catch (Exception e) {
			log.error("REDIS GET METHOD ERROR", e);
			broken = true;
		} finally {
			redisDataSource.returnResource(redisObj, broken);
		}
		return result;
	}

	public long delInfo(String key){
		long result = 0;
		Jedis redisObj = redisDataSource.getRedisObj();
		if (redisObj == null) {
			return result;
		}

		boolean broken = false;
		try {
			result = redisObj.del(key);

		} catch (Exception e) {
			log.error("REDIS GET METHOD ERROR", e);
			broken = true;
		} finally {
			redisDataSource.returnResource(redisObj, broken);
		}
		return result;
	}
	/**
	 * 删除user
	 * @param key
	 * @return
	 */
	public long delUser(String key){
		long result = 0;
		Jedis redisObj = redisDataSource.getRedisObj();
		if (redisObj == null) {
			return result;
		}

		boolean broken = false;
		try {
			result = redisObj.del(CommonConstants.WEB_USER+":"+key);

		} catch (Exception e) {
			log.error("REDIS GET METHOD ERROR", e);
			broken = true;
		} finally {
			redisDataSource.returnResource(redisObj, broken);
		}
		return result;
	}

}
