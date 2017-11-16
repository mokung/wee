package me.wenkang.wee.config;

import lombok.extern.slf4j.Slf4j;
import me.wenkang.wee.biz.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by wenkang
 * on 2017/11/14.
 */
@SpringBootConfiguration
@Slf4j
public class RedisConfig extends CachingConfigurerSupport {
    @Bean
    public JedisPool redisPoolFactory(@Value("${spring.redis.host}") String host,
            @Value("${spring.redis.port}") int port,
            @Value("${spring.redis.timeout}") int timeout,
            @Value("${spring.redis.pool.max-idle}") int maxIdle,
            @Value("${spring.redis.pool.max-wait}") long maxWaitMillis) {
        log.info("redis addresss：" + host + ":" + port);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setMaxTotal(1024);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
        log.info("JedisPool register success！！");
        // init RedisUtils
        RedisUtils.init(jedisPool);
        return jedisPool;
    }
}
