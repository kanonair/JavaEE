package io.kanonair.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDemo {

    @Test
    public void example01() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String state = jedis.set("name", "Taylor");
        System.out.println("state = " + state);
        jedis.close();
    }

    @Test
    public void example02() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String name = jedis.get("name");
        System.out.println("name = " + name);
        jedis.close();
    }

    @Test
    public void example03() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Long aLong = jedis.del("name");
        System.out.println("aLong = " + aLong);
        jedis.close();
    }

    @Test
    public void example04() {
        JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);
        Jedis jedis = jedisPool.getResource();
        Long aLong = jedis.del("name");
        System.out.println("aLong = " + aLong);
        jedis.close();
        jedisPool.close();
    }

}
