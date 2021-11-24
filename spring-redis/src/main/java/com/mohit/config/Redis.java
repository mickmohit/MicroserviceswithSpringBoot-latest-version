package com.mohit.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.mohit.model.User;

@Configuration
@EnableCaching
public class Redis {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration =
				new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setHostName("127.0.0.1");
		redisStandaloneConfiguration.setPort(13283);//6379-default port for redis
		//redisStandaloneConfiguration.setPassword("password");
		
		JedisConnectionFactory jedisConnectionFactory= new JedisConnectionFactory(redisStandaloneConfiguration);
		return jedisConnectionFactory;
	}
	
	@Bean
	public RedisTemplate<String,User> redisTemplate() {
		RedisTemplate<String, User> redisTemplate= new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setEnableTransactionSupport(true);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
}
