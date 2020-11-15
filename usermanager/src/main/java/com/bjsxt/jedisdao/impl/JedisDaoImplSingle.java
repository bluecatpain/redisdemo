package com.bjsxt.jedisdao.impl;


import com.bjsxt.jedisdao.JedisDao;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisDaoImplSingle implements JedisDao {


    private JedisPool jedisPool;

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis =jedisPool.getResource();
        return  jedis.set(key, value);

    }

    @Override
    public String get(String key) {
        Jedis jedis =jedisPool.getResource();
        return  jedis.get(key);
    }

    @Override
    public Long hset(String hkey, String key, String value) {
        Jedis jedis =jedisPool.getResource();
        return  jedis.hset(hkey,key, value);
    }

    @Override
    public String hget(String hkey, String key) {
        Jedis jedis =jedisPool.getResource();
        return  jedis.hget(hkey,key);
    }

    @Override
    public long expire(String key, int sec) {
        Jedis jedis=jedisPool.getResource();
        return jedis.expire(key, sec);
    }

    @Override
    public long del(String key) {
        Jedis jedis=jedisPool.getResource();
        return jedis.del(key);
    }
}
