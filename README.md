# Kafka Order Event Processing System

An event-driven microservices application built using **Java Spring Boot** and **Apache Kafka**.  
The system demonstrates asynchronous communication between services using Kafka as a message broker.

---

## Overview

Order-related events are published to Kafka and consumed by downstream services.  
Services communicate indirectly through Kafka, ensuring loose coupling and scalability.

---

## Architecture

Client → Order Service (Producer) → Kafka Topic (`order-events`) → Notification Service (Consumer)

- Services do not communicate directly
- Kafka acts as the central event broker
- Each service can scale independently

---

## Services

### Order Service (Producer)

- Exposes a REST API to create orders
- Publishes order events to Kafka topic `order-events`

**Endpoint**

POST /orders

**Request Example**
```json
{
  "orderId": "ORD-001",
  "product": "LED Monitor",
  "quantity": 3,
  "amount": 630000
}
```

### Event Published

Order sent to Kafka

```json
{
  "orderId": "ORD-001",
  "eventType": "ORDER_CREATED",
  "product": "LED Monitor",
  "quantity": 3,
  "amount": 630000
}
```

### Notification Service (Consumer)

- Subscribes to Kafka topic order-events
- Consumes order events asynchronously
- Logs event details for further processing

### Kafka Configuration

- Topic: order-events
- Message key: orderId
- Serialization: JSON
- Consumer group used for message consumption

### Technology Stack

- Java 17
- Spring Boot
- Spring for Apache Kafka
- Apache Kafka
- Docker & Docker Compose
- Maven

## Running the Application

- Start Kafka (docker-compose up -d)
- Start Order Service
- Start Notification Service

## Author
- Shehryar
