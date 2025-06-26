package com.example.notificationservice.controller;

import com.example.notificationservice.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<String> sendNotification(
            @RequestParam String to,
            @RequestParam String message) {
        notificationService.send(to, message);
        return ResponseEntity.ok("Notification request accepted.");
    }
}
