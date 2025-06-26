# Microservices Architecture: User Management, Notifications, and Analytics (Spring Boot)

This project demonstrates a production-style microservices architecture using Spring Boot. It features three independent services — `user-service`, `notification-service`, and `analytics-service` — designed to simulate real-world backend modularity, scalability, and fault tolerance.

Each service is independently runnable, communicates via HTTP using `RestTemplate`, and is structured with best practices like clean layered architecture, async processing, exception handling, and in-memory persistence for fast iteration.

## Tech Stack

- Java 17  
- Spring Boot 3.x  
- Spring Web, Spring Data JPA  
- Spring Async (`@Async`)  
- H2 In-Memory Database  
- RestTemplate (HTTP inter-service communication)  
- Swagger (OpenAPI Docs)  

## Features

### 🧩 Microservices Breakdown

#### user-service
- Handles user creation and updates  
- Triggers notification and analytics events after user creation  
- Validates input and ensures email uniqueness  

#### notification-service
- Simulates email/SMS notifications  
- Asynchronous notification dispatch via `@Async`  
- Logs message details to the console  

#### analytics-service
- Accepts user activity logs from external services  
- Persists event logs to an H2 database  
- Auto-timestamps events with JPA auditing  

## Architecture

Client
↓
user-service
├── POST /api/users
├── → notification-service (send notification)
└── → analytics-service (log event)


- Services are decoupled — a failure in notification or analytics does not affect core user flow  
- Notification calls are asynchronous to simulate non-blocking user experience  
- Logs and DB storage simulate real-world traceability and observability  

## API Overview

### user-service (localhost:8081)
**POST /api/users**  
Creates a user and triggers downstream services.  
Request body:
```json
{
  "name": "Alice",
  "email": "alice@example.com",
  "role": "ADMIN"
}
```
notification-service (localhost:8082)
POST /api/notifications?to=email&message=text
Simulates sending a notification to a user.

analytics-service (localhost:8083)
POST /api/analytics?event=text
Logs an analytics event (e.g., “User created: email”).


## Author

Gaurav Solanki  
GitHub: https://github.com/GauravS0001
