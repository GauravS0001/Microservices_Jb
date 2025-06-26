package com.example.userservice.service;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.entity.User;
import com.example.userservice.exception.UserAlreadyExistsException;
import com.example.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User createUser(UserDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new UserAlreadyExistsException("Email already exists: " + dto.getEmail());
        }

        User user = new User(dto.getName(), dto.getEmail(), dto.getRole(), LocalDateTime.now());
        User saved = userRepository.save(user);

        // Send notification
        String notificationUrl = "http://localhost:8082/api/notifications?to={to}&message={message}";
        restTemplate.postForObject(notificationUrl, null, Void.class, saved.getEmail(), "Welcome " + saved.getName());

        // Log analytics
        String analyticsUrl = "http://localhost:8083/api/analytics?event={event}";
        restTemplate.postForObject(analyticsUrl, null, Void.class, "User created: " + saved.getEmail());

        return saved;
    }
}
