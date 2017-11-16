package me.wenkang.wee.biz.utils;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by wenkang
 * on 2017/11/14.
 */
@Slf4j
public class RedisUtils {
    private static JedisPool JEDIS_POOL;

    private RedisUtils() {
    }

    public static synchronized void init(JedisPool jedisPool) {
        if (RedisUtils.JEDIS_POOL == null) {
            RedisUtils.JEDIS_POOL = jedisPool;
        }
    }


    public static void accept(Consumer<Jedis> consumer) {
        try (Jedis jedis = JEDIS_POOL.getResource()) {
            consumer.accept(jedis);
        } catch (Exception e) {
            log.error("RedisUtils operate error: ", e);
            throw new RedisException(e);
        }
    }

    public static <T> T apply(Function<Jedis, T> function) {
        try (Jedis jedis = JEDIS_POOL.getResource()) {
            return function.apply(jedis);
        } catch (Exception e) {
            log.error("RedisUtils operate error: ", e);
            throw new RedisException(e);
        }
    }

    public static class RedisException extends RuntimeException {
        public RedisException() {
            super();
        }

        public RedisException(String message) {
            super(message);
        }

        public RedisException(String message, Throwable cause) {
            super(message, cause);
        }

        public RedisException(Throwable cause) {
            super(cause);
        }

        protected RedisException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

}
