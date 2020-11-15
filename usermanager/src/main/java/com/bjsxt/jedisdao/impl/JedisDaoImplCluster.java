package com.bjsxt.jedisdao.impl;


import com.bjsxt.jedisdao.JedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

public class JedisDaoImplCluster implements JedisDao {

    @Autowired
     private  JedisCluster jedisCluster;

    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key, value);
    }

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public Long hset(String hkey, String key, String value) {
        return jedisCluster.hset(hkey, key,value);
    }

    @Override
    public String hget(String hkey, String key) {
        return jedisCluster.hget(hkey, key);
    }

    @Override
    public long expire(String key, int sec) {
        return 0;
    }

    @Override
    public long del(String key) {
        return 0;
    }
}
