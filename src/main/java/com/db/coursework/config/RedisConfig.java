package com.db.coursework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;

@Configuration
@PropertySource("classpath:application.properties")
public class RedisConfig {
    @Resource
    private Environment environment;
    @Value("${spring.datasource.url}")
    private String datasource;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public StringRedisTemplate redisTemplate(final RedisConnectionFactory connectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(connectionFactory);
        return template;
    }
    @Bean
    public DriverManagerDataSource DataSource(final RedisConnectionFactory connectionFactory) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));

        dataSource.setUsername(redisTemplate(connectionFactory).opsForValue().get(username));

        dataSource.setPassword(redisTemplate(connectionFactory).opsForValue().get(password));
        dataSource.setUrl(datasource);
        return dataSource;
    }
}
