# Esource Number App

**A simple, well-structured Java (Spring Boot) application that:**
- Generates three arrays of random integers.
- Identifies which numbers in a specified range are not found in any array (the “available numbers”).
- Finds the largest prime number from these available numbers, if any.

This project showcases clean coding principles, unit testing, and containerization using Docker.

## Features

1. **Random Arrays Generation**
   - Produces three separate arrays, each containing 15 random integers in the range [0–50].

2. **Available Numbers Extraction**
   - Determines which integers in [0–50] are **not** present in any of the generated arrays.
   - Returns them as a list of “available numbers.”

3. **Prime Number Identification**
   - Finds the largest prime number from the resulting list of available numbers.
   - If no prime is found, it clearly indicates so.

## Technologies and Practices

- **Language & Framework:**  
  Java 17 with [Spring Boot](https://spring.io/projects/spring-boot)
  
- **Build Tool:**  
  [Maven](https://maven.apache.org/)
  
- **Testing:**  
  [JUnit 5](https://junit.org/junit5/) integrated with Spring Boot starter test  
  Comprehensive unit tests ensure correctness and maintainability.

- **Containerization:**  
  [Docker](https://www.docker.com/) used for creating a portable, production-like environment.

## Getting Started

### Prerequisites

- **Java 17+**
- **Maven 3.8+**
- **Git** (to clone the repository)
- **Docker** (optional, for running the containerized version)

### Installation & Running

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/esource-number-app.git
   cd esource-number-app
2. **Build the Application:**
   ```bash
   mvn clean package
3. **Run the Application:**
   ```bash
   java -jar target/demo-0.0.1-SNAPSHOT.jar

## Docker Usage

1. **Build the Docker Image:**
   ```bash
   docker build -t my-springboot-app:latest .
2. **Run the Docker Container:**
   ```bash
   docker run --rm my-springboot-app:latest

## Branch Managment

- **Main Branch:** Stable code with tested features.
- **Feature Branches:** New features or PR reviews are done in separate branches (e.g., PR-Review-Using-Chat-GPT).
