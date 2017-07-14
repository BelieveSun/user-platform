package com.believe.sun.user.config;


import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.net.UnknownHostException;

/**
 * Created by sungj on 17-6-26.
 */
@Configuration
//@EnableConfigurationProperties(RedisProperties.class)
//@EnableRedisRepositories(basePackages = "com.believe.sun.user.dao",enableKeyspaceEvents = RedisKeyValueAdapter.EnableKeyspaceEvents.ON_STARTUP)
public class RedisConfig {

//    @Bean("sessionRedisTemplate")
//    @Autowired
//    public  RedisTemplate<String,Session> redisTemplate(
//            RedisConnectionFactory redisConnectionFactory)
//            throws UnknownHostException {
//        RedisTemplate<String , Session> template = new RedisTemplate<>();
//        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Session.class));
//        template.setConnectionFactory(redisConnectionFactory);
//        return template;
//    }


//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix = "spring.redis")
//    RedisProperties redisProperties(){
//        return new RedisProperties();
//    }

//    @Bean
//    public List<PatternTopic> topicList() {
//        List<PatternTopic> list = new ArrayList<>();
//        list.add(new PatternTopic("__key*"));
//        return list;
//    }

//    @Bean
//    MessageListenerAdapter messageListener() {
//        return new MessageListenerAdapter(new RedisListener(redisTemplate));
//    }

//    @Bean
//    @Primary
//    RedisConnectionFactory redisConnectionFactory(){
//        RedisProperties redisProperties = redisProperties();
//        JedisPoolConfig poolConfig = redisProperties.getPool() != null
//                ? jedisPoolConfig(redisProperties) : new JedisPoolConfig();
//        RedisProperties.Cluster clusterProperties = redisProperties.getCluster();
//        RedisClusterConfiguration config = new RedisClusterConfiguration(
//                clusterProperties.getNodes());
//
//        if (clusterProperties.getMaxRedirects() != null) {
//            config.setMaxRedirects(clusterProperties.getMaxRedirects());
//        }
//        return new JedisConnectionFactory(config,poolConfig);
//    }
//
//    private JedisPoolConfig jedisPoolConfig(RedisProperties redisProperties) {
//        JedisPoolConfig config = new JedisPoolConfig();
//        RedisProperties.Pool props = redisProperties.getPool();
//        config.setMaxTotal(props.getMaxActive());
//        config.setMaxIdle(props.getMaxIdle());
//        config.setMinIdle(props.getMinIdle());
//        config.setMaxWaitMillis(props.getMaxWait());
//        return config;
//    }
//
//    @Bean
//    RedisMessageListenerContainer redisContainer(RedisConnectionFactory factory) {
//        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(factory);
//        container.addMessageListener(messageListener(), topicList());
//        return container;
//    }
}
