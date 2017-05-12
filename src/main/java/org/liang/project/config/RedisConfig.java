package org.liang.project.config;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

	@Bean
	public CacheManager cacheManager(RedisTemplate<String,String> template) {
		return new RedisCacheManager(template);
	}

	@Bean
	@Override
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder builder = new StringBuilder();
				builder.append(target.getClass().getName());
				builder.append(method.getName());
				for(Object param:params){
					builder.append(param.toString());
				}
				return builder.toString();
			}
		};
	}
	
	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){
		RedisTemplate<String, String> template = 
				new RedisTemplate<String, String>();
		template.setConnectionFactory(factory);
		return template;
	}
	
	@Bean
	public JedisConnectionFactory redisConnectionFactory(){
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName("localhost");
		factory.setPort(6379);
		return factory;
	}
}
