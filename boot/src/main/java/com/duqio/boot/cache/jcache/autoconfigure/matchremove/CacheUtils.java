package com.duqio.boot.cache.jcache.autoconfigure.matchremove;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;

import com.duqio.boot.secret.shiro.util.SpringContextUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheUtils {

	private static CacheManager cacheManager = (CacheManager) SpringContextUtil.getApplicationContext().getBean("jCacheCacheManager");
	
	
	public static <K, V> V get(String cacheName, K key) {
		Cache<K, V> cache = getCache(cacheName);
		V value = cache.get(key);
		return value == null ? null : value;
	}

	public static <K, V> void put(String cacheName, K key, V value) {
		Cache<K, V> cache = getCache(cacheName);
		cache.put(key, value);
	}

	public static <K, V> void remove(String cacheName, K key) {
		Cache<K, V> cache = getCache(cacheName);
		cache.remove(key);
	}

	public static <K, V> List<K> cacheKeys(String cacheName) {
		List<K> result = new ArrayList<>();
		Cache<K, V> cache = getCache(cacheName);
		cache.forEach(entry -> {
			result.add(entry.getKey());
		});
		return result;
	}
	
	/**
     * 获得一个Cache，没有则创建一个。
     * @param cacheName
     * @return
     */
    private static <K, V> Cache<K, V> getCache(String cacheName) {
        Cache<K, V> cache = cacheManager.getCache(cacheName);
        if (cache == null) {
        	Configuration<?, ?> configuration;
        	configuration = SpringContextUtil.getApplicationContext().getBean(Configuration.class);
        	log.info("the default configuration is null ? " + Objects.isNull(configuration));
        	if(Objects.isNull(configuration))
        		configuration = new MutableConfiguration<>();
        	cacheManager.createCache(cacheName, configuration);
        	cache = cacheManager.getCache(cacheName);
        }
        return cache;
    }

    public static CacheManager getCacheManager() {
        return cacheManager;
    }
	
}
