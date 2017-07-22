package com.ai.ge.platform.service.redis;

public interface RedisCache {
	  <T> T getRedisCacheInfo(String key);

	  <T> boolean setRedisCacheInfo(String key, T value);
}
