package com.example.unique_id_generator.services;
import com.example.unique_id_generator.repositories.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UniqueIDService {
    private final RedisRepository redisRepository;
    @Value("${spring.application.datacenter.id}")
    private String centerId;
    @Value("${spring.application.machine.id}")
    private String serverId;
    @Autowired
    public UniqueIDService(RedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }
    public String generateUniqueID() {
        Long now = Instant.now().toEpochMilli();
        Long sequenceNumber= redisRepository.executeScript();
        return     now + centerId+ serverId+sequenceNumber;

    }
}
