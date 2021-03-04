package com.hl.schoolbar.shiro.cache;

import lombok.Data;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;

/**
 * author: huangLong
 * date:2020/12/7 16:37
 * describe:自定义redis缓存的实现
 */

@Data
@Component
public class RedisCache<K,V> implements Cache<K,V> {

    private String cacheName;

    public RedisCache(String cacheName) {
        this.cacheName = cacheName;
    }

    public RedisCache() {
    }

    @Resource
    RedisTemplate redisTemplate;

    @Override
    public V get(K k) throws CacheException {
        System.out.println("=================================get k="+k);


//        return (V)getRedisTemplate().opsForHash().get(this.cacheName,k.toString());
        return (V)redisTemplate.opsForHash().get(this.cacheName,k.toString());
//        return null;
    }

    @Override
    public V put(K k, V v) throws CacheException {
        System.out.println("=============================put k="+k);
        System.out.println("==============================put v="+v);
        System.out.println(cacheName);
        redisTemplate.opsForHash().put(this.cacheName,k.toString(),v);
        return null;
    }

    @Override
    public V remove(K k) throws CacheException {
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }


}
