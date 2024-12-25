package com.example.unique_id_generator.repositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Repository;

import java.util.Collections;

@Repository
public class RedisRepositoryImpl implements RedisRepository {

    private final RedisTemplate<String, String> redisTemplate;
    private final RedisScript<Long> redisScript;
    @Value("${spring.application.max_sequence_number}")
    private String max_sequence_number;
    @Value("${spring.application.refresh_time}")
    private String refresh_time;

    public RedisRepositoryImpl(RedisTemplate<String, String> redisTemplate, RedisScript<Long> redisScript) {
        this.redisTemplate = redisTemplate;
        this.redisScript = redisScript;
    }

    @Override
    public Long executeScript() {
        return redisTemplate.execute(redisScript, Collections.singletonList("counter"),max_sequence_number,refresh_time);
    }
}
