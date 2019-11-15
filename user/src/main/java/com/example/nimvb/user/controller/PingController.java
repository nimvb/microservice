package com.example.nimvb.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pings")
public class PingController {

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @GetMapping
    public ResponseEntity ping() {
        return ResponseEntity.ok(instanceId);
    }
}
