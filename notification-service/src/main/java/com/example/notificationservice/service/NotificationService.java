package com.example.notificationservice.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Async
    public void send(String to, String message) {
        try {
            Thread.sleep(2000); // simulate delay
            System.out.printf("Notification sent to %s: %s%n", to, message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Notification sending interrupted");
        }
    }
}