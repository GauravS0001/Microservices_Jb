package com.example.analyticsservice.controller;

import com.example.analyticsservice.service.AnalyticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @PostMapping
    public ResponseEntity<String> logEvent(@RequestParam String event) {
        analyticsService.log(event);
        return ResponseEntity.ok("Event logged successfully.");
    }
}