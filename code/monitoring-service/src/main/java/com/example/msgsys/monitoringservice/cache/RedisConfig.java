package com.example.msgsys.monitoringservice.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.PostConstruct;

@Configuration
public class RedisConfig {

    @Value("${redis.hostname:localhost}")
    private String redisHostName;
    @Value("${redis.port:6379}")
    private int redisPort;
    @Value("${redis.redis.database:0}")
    private int redisDatabase;
    private RedisStandaloneConfiguration redisStandaloneConfiguration;

    @PostConstruct
    public void init() {
        redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisHostName);
        redisStandaloneConfiguration.setPort(redisPort);
        redisStandaloneConfiguration.setDatabase(redisDatabase);
    }

    @Bean
    RedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory(redisStandaloneConfiguration);

        return jedisConFactory;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate() {
        StringRedisTemplate template = new StringRedisTemplate(redisConnectionFactory());

        return template;
    }
}
