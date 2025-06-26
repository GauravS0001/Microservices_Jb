package com.example.analyticsservice.service;

import com.example.analyticsservice.entity.EventLog;
import com.example.analyticsservice.repository.EventLogRepository;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    private final EventLogRepository repository;

    public AnalyticsService(EventLogRepository repository) {
        this.repository = repository;
    }

    public void log(String event) {
        EventLog log = new EventLog(event);
        repository.save(log);
        System.out.println("Analytics event logged: " + event);
    }
}