//package com.huangpeng.cache.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * <pre>
// * 任务：
// * 描述：
// * 作者：@author huangpeng
// * 时间：@create 2018-06-23 上午11:27
// * 类名: RedisConfig
// * </pre>
// **/
//@Configuration
//@EnableCaching
//public class RedisConfig {
//    @Value("${spring.cache.redis.host}")
//    private String host;
//    @Value("${spring.cache.redis.password}")
//    private String password;
//    @Value("${spring.cache.redis.port}")
//    private int port;
//    @Value("${spring.cache.redis.timeout}")
//    private int timeout;
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(jedisConnectionFactory);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        return template;
//    }
//
//    @Bean(name = "redisKeyGenerator")
//    public static KeyGenerator customKeyGenerator() {
//        return (o, method, objects) -> {
//            StringBuilder sb = new StringBuilder();
////                sb.append(o.getClass().getName());
//            sb.append(method.getName());
//            for (Object obj : objects) {
//                sb.append((obj == null) ? "null" : obj.toString());
//            }
//            return sb.toString();
//        };
//    }
//
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory(){
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//        jedisConnectionFactory.setHostName(host);
//        jedisConnectionFactory.setPort(port);
//        jedisConnectionFactory.setPassword(password);
//        jedisConnectionFactory.setTimeout(timeout);
//        return jedisConnectionFactory;
//    }
//
//    @Bean(name = "redisCacheManager")
//    public RedisCacheManager redisCacheManager(RedisTemplate redisTemplate){
//        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        return cacheManager;
//    }
//
//}
