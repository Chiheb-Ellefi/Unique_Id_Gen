package com.example.unique_id_generator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

@Configuration
public class RedisScriptConfig {
    @Bean
    RedisScript<Long> redisScript(){
        DefaultRedisScript<Long> script =new DefaultRedisScript<>();
        script.setResultType(Long.class);
        script.setLocation(new ClassPathResource("scripts/redis.lua"));
        return script;
        }

}
