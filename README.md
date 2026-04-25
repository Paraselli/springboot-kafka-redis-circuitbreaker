# 🚀 Spring Boot Kafka Redis Circuit Breaker

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge\&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3-green?style=for-the-badge\&logo=springboot)
![Kafka](https://img.shields.io/badge/Apache_Kafka-Event_Driven-black?style=for-the-badge\&logo=apachekafka)
![Redis](https://img.shields.io/badge/Redis-Cache-red?style=for-the-badge\&logo=redis)
![Resilience4j](https://img.shields.io/badge/Resilience4j-Circuit_Breaker-blue?style=for-the-badge)
![Docker](https://img.shields.io/badge/Docker-Containerized-blue?style=for-the-badge\&logo=docker)

### ⚡ Production-style Spring Boot backend showcasing Kafka, Redis caching, and Circuit Breaker resilience

</div>

---

## 📌 Overview

This project is a **portfolio-ready Spring Boot 3 backend application** built to demonstrate modern backend engineering practices including:

* **Event-driven communication** using Apache Kafka
* **High-speed caching** with Redis
* **Fault tolerance** using Resilience4j Circuit Breaker
* **Containerized local setup** with Docker Compose
* **Clean layered architecture** for production-grade backend services

It is designed as a simple **Product Service** where product events are cached, published, and protected with resilience patterns.

---

## 🏗️ Architecture

```text
                        +-------------------+
                        |      Client       |
                        +---------+---------+
                                  |
                                  v
                        +-------------------+
                        | ProductController |
                        +---------+---------+
                                  |
                                  v
                        +-------------------+
                        |  ProductService   |
                        +----+---------+----+
                             |         |
               Cache Write/Read        | Publish Event
                             |         |
                             v         v
                    +-------------+   +----------------+
                    |    Redis    |   | Apache Kafka   |
                    |   Cache     |   | product-topic  |
                    +-------------+   +----------------+
                             |
                             v
                    +----------------------+
                    | Circuit Breaker      |
                    | Resilience4j Fallback|
                    +----------------------+
```

---

## ✨ Features

* ✅ REST API with Spring Boot 3
* ✅ Kafka Producer for event publishing
* ✅ Redis for in-memory caching
* ✅ Circuit Breaker fallback with Resilience4j
* ✅ Docker Compose for local infrastructure
* ✅ Clean code & interview-ready structure
* ✅ GitHub portfolio ready

---

## 🛠️ Tech Stack

| Technology     | Purpose           |
| -------------- | ----------------- |
| Java 17        | Core language     |
| Spring Boot 3  | Backend framework |
| Apache Kafka   | Event streaming   |
| Redis          | Caching           |
| Resilience4j   | Circuit breaker   |
| Maven          | Build tool        |
| Docker Compose | Local infra       |

---

## 📂 Project Structure

```bash
springboot-kafka-redis-circuitbreaker/
│── src/main/java/com/example/demo
│   ├── controller/
│   │   └── ProductController.java
│   ├── service/
│   │   └── ProductService.java
│   ├── kafka/
│   │   └── ProductProducer.java
│   ├── config/
│   │   ├── KafkaConfig.java
│   │   └── RedisConfig.java
│   ├── model/
│   │   └── Product.java
│   └── DemoApplication.java
│
│── src/main/resources/
│   └── application.yml
│
│── docker-compose.yml
│── pom.xml
└── README.md
```

---

## ⚙️ Setup & Run

### 1️⃣ Clone Repository

```bash
git clone https://github.com/Paraselli/springboot-kafka-redis-circuitbreaker.git
cd springboot-kafka-redis-circuitbreaker
```

### 2️⃣ Start Infrastructure

```bash
docker-compose up -d
```

This starts:

* Kafka
* Zookeeper
* Redis

### 3️⃣ Run Application

```bash
mvn spring-boot:run
```

Application runs on:

```bash
http://localhost:8080
```

---

## 📬 API Endpoints

### ➕ Save Product

```http
POST /products
```

#### Request Body

```json
{
  "id": 1,
  "name": "iPhone 15",
  "price": 79999
}
```

#### What happens?

* Product is cached in Redis
* Product event is published to Kafka topic

---

### 🔍 Get Product

```http
GET /products/1
```

#### Response

```json
{
  "id": 1,
  "name": "iPhone 15",
  "price": 79999
}
```

---

### 🛡️ Circuit Breaker Fallback

If Redis is unavailable or product is missing:

```json
{
  "id": 1,
  "name": "Default Product",
  "price": 0.0
}
```

---

## 🔁 Request Flow

1. Client sends product request
2. API stores product in Redis
3. Service publishes product event to Kafka
4. Client fetches product
5. If failure occurs → Circuit Breaker returns fallback response

---

## 📦 Kafka Event Flow

```text
Product Created
     |
     v
ProductService
     |
     v
ProductProducer
     |
     v
Kafka Topic (product-topic)
```

---

## 🚨 Resilience Strategy

This project uses **Resilience4j Circuit Breaker** to prevent cascading failures.

### Circuit Breaker Behavior

* **Closed** → normal flow
* **Open** → fallback response returned
* **Half Open** → test recovery

This ensures the service remains stable even when dependencies fail.

---

## 🐳 Docker Services

```yaml
Zookeeper : 2181
Kafka     : 9092
Redis     : 6379
App       : 8080
```

---

## 🎯 Why This Project Matters

This project demonstrates real-world backend engineering patterns used in modern microservices:

* Event-driven design
* Distributed caching
* Failure isolation
* Resilient service communication
* Production-like architecture

Perfect for:

* Backend interviews
* Resume projects
* GitHub portfolio
* Spring Boot hands-on practice

---

## 👨‍💻 Author

---

### Ram Paraselli

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Profile-0A66C2?style=for-the-badge\&logo=linkedin)](https://www.linkedin.com/in/paraselli)

[![GitHub](https://img.shields.io/badge/GitHub-Profile-181717?style=for-the-badge\&logo=github)](https://github.com/Paraselli)

---

## ⭐ Support

If this project helped you, consider giving it a **star** ⭐ on GitHub.
