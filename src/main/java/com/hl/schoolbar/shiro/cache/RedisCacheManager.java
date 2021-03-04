package com.hl.schoolbar.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * author: huangLong
 * date:2020/12/7 15:47
 * describe:自定义shiro集成redis
 */

public class RedisCacheManager implements CacheManager {

    @Autowired
    RedisCache redisCache;


    /**
     * s是管理器名称
     * @param s
     * @param <K>
     * @param <V>
     * @return
     * @throws CacheException
     */
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        System.out.println("======进入RedisCacheManager====="+s);
        redisCache.setCacheName(s);
        return redisCache;
    }

}
