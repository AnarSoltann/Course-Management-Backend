package com.ansdev.course_management_backend.configs;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

@Configuration
public class RedissonConfig {

    private final ResourceLoader resourceLoader;
    private final Environment environment;

    @Autowired
    public RedissonConfig(ResourceLoader resourceLoader, Environment environment) {
        this.resourceLoader = resourceLoader;
        this.environment = environment;
    }

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() throws IOException {
        String redissonConfigPath = environment.getProperty("spring.redis.redisson.file");
        assert redissonConfigPath != null;
        Config config = Config.fromYAML(resourceLoader.getResource(redissonConfigPath).getInputStream());
        return Redisson.create(config);
    }
}