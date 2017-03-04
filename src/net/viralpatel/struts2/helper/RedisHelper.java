package net.viralpatel.struts2.helper;

import redis.clients.jedis.Jedis;

public class RedisHelper {
	
	private static RedisHelper redisHelper;
	
	private Jedis jedis;
	
	public static RedisHelper getInstance() {
		
		if (redisHelper != null && redisHelper instanceof RedisHelper) {
			return redisHelper;
		} else {
			redisHelper = new RedisHelper();
			return redisHelper;
		}
		
	}
	
	public RedisHelper() {
		
		setJedis(new Jedis("127.0.0.1", 6379));
		
	}
	
	public void setJedis(Jedis jedis) {
		
		this.jedis = jedis;
		
	}
	
	public Jedis getJedis() {
		
		return this.jedis;
		
	}
	
	public String get(String key) {
		
		return getJedis().get(key);
	
	}
	
	public void set(String key, String value, int ...ttl) {
		
		getJedis().set(key, value);
	
		if (ttl.length < 1) {
			ttl = new int[]{0};
		}
		
		int seconds;
		if ((seconds = ttl[0]) > 0) {
			expire(key, seconds);
		}
		
	}
	
	public void expire(String key, int ttl) {
		
		getJedis().expire(key, ttl);
		
	}
	
	public void setNx(String key, String value, int ...ttl) {
		
		getJedis().setnx(key, value);
		
		if (ttl.length < 1) {
			ttl = new int[]{0};
		}
		
		int seconds;
		if ((seconds = ttl[0]) > 0) {
			expire(key, seconds);
		}
		
	}
	
}
