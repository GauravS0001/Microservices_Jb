Microservices Demo — User Management, Notifications, and Analytics
This project demonstrates a clean microservices-based architecture using Spring Boot. It includes three independent services — User Service, Notification Service, and Analytics Service — each designed to handle a specific business responsibility. The system is built to reflect real production patterns such as modularity, asynchronous processing, and inter-service communication.

Services Overview
Service	Description	Port
user-service	Handles user operations. Triggers notifications and logging.	8081
notification-service	Accepts requests to send simulated notifications.	8082
analytics-service	Logs user activity events to an in-memory DB.	8083

Each service is a fully standalone Spring Boot application with its own configuration, REST API, and domain logic.

Technologies Used
Java 17

Spring Boot 3.x

Spring Web, Spring Data JPA, Spring Async

H2 In-Memory Database

RestTemplate for inter-service calls

Swagger/OpenAPI for API documentation

Maven for build

Docker-ready structure (optional)

System Architecture
Data flow when a user is created:

Client calls user-service → POST /api/users

User is persisted to DB

user-service sends:

A notification request to notification-service

A log event to analytics-service

Each call is independent to ensure fault isolation between services.

Folder Structure
microservices-demo/
├── user-service/
├── notification-service/
├── analytics-service/
└── README.md

Each service contains its own pom.xml, config, and business layers.

How to Run
Prerequisites
Java 17+

Maven 3.6+

Git

Steps
Open three terminals and run each service:

Terminal 1
cd user-service
./mvnw spring-boot:run

Terminal 2
cd notification-service
./mvnw spring-boot:run

Terminal 3
cd analytics-service
./mvnw spring-boot:run

Test Endpoints
Use Postman or curl to test the interaction.

Create a user:
curl -X POST http://localhost:8081/api/users \
-H "Content-Type: application/json" \
-d '{"name":"John Doe","email":"john@example.com","role":"USER"}'

notification-service will print the simulated notification.
analytics-service will log the event.

REST API Summary
user-service (localhost:8081)
POST /api/users
Body: { "name": "John", "email": "john@example.com", "role": "USER" }

notification-service (localhost:8082)
POST /api/notifications?to=...&message=...

analytics-service (localhost:8083)
POST /api/analytics?event=...

Key Concepts Demonstrated
Clean layered architecture with Controller → Service → Repository

Inter-service communication using RestTemplate

Fault isolation: one service failing does not crash others

Asynchronous request handling using @Async

Database interaction using Spring Data JPA + H2

REST API validation and global exception handling

Swagger UI documentation available (optional)

How This Reflects Real-World Backend Work
Each service encapsulates a single business domain and can be deployed independently

Logging and notifications are handled as side-effect services to keep the core system responsive

System is designed to scale horizontally and be extended (e.g., with messaging, auth, or gateway)

Optional: Docker Integration
You can extend this setup with:

Dockerfile per service

A docker-compose.yml to run all services together

This is useful for deployment simulation and container orchestration practice.

Author
Gaurav Solanki
GitHub: https://github.com/GauravS0001
LinkedIn: https://linkedin.com/in/gaurav-solanki-043734173

License
MIT
