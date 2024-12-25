package com.example.unique_id_generator.controllers;

import com.example.unique_id_generator.services.UniqueIDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class MainController {
    private  final UniqueIDService uniqueIDService;
    private final  Logger logger = Logger.getLogger(MainController.class.getName());
    public MainController(UniqueIDService uniqueIDService) {
        this.uniqueIDService = uniqueIDService;
    }

    @GetMapping
    ResponseEntity<String> getUniqueId() {
        String uniqueId= uniqueIDService.generateUniqueID();
        logger.info("Generated unique ID: " + uniqueId);
        return ResponseEntity.ok(uniqueId);
    }
}
