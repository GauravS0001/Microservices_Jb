package com.example.analyticsservice.repository;

import com.example.analyticsservice.entity.EventLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventLogRepository extends JpaRepository<EventLog, Long> {
}