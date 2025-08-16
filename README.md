# Spring Boot RESTful Web Service Example

A simple RESTful web service built with Spring Boot. This project serves as a practical example of building REST APIs for managing a `User` resource. It demonstrates core concepts such as dependency injection, custom exception handling, and input validation.

## Features

*   **RESTful API:** Exposes endpoints for CRUD (Create, Read, Delete) operations on Users.
*   **In-Memory Data Store:** Uses a simple `ArrayList` to store user data for demonstration purposes.
*   **Input Validation:** Leverages Jakarta Bean Validation (`@Valid`, `@Size`, `@Past`) to validate incoming request data.
*   **Custom Exception Handling:** Implements a centralized exception handler (`@RestControllerAdvice`) to provide consistent and meaningful error responses for different scenarios:
    *   `404 Not Found` when a user does not exist.
    *   `400 Bad Request` when input validation fails.
    *   `500 Internal Server Error` for all other unhandled exceptions.
*   **Structured Error Responses:** Defines a clear JSON structure for error messages via the `ErrorDetails` class.

## Technologies Used

*   Java 17+
*   Spring Boot 3+
*   Spring Web
*   Jakarta Bean Validation
*   Lombok
*   Maven

## Getting Started

### Prerequisites

*   JDK 17 or later
*   Maven 3.x

### Running the Application

1.  Clone the repository:
    ```bash
    git clone <your-repository-url>
    ```
2.  Navigate to the project directory:
    ```bash
    cd rest-web-services
    ```
3.  Run the application using the Maven Spring Boot plugin:
    ```bash
    mvn spring-boot:run
    ```
The application will start on `http://localhost:8080`.

## API Endpoints

The base URL for all endpoints is `http://localhost:8080`.

---

#### 1. Retrieve All Users

*   **Endpoint:** `GET /users`
*   **Description:** Fetches a list of all users.
*   **Success Response (`200 OK`):**
    ```json
    [
        {
            "id": 1,
            "name": "Adam",
            "date": "1990-10-20"
        },
        {
            "id": 2,
            "name": "Eve",
            "date": "1992-05-15"
        }
    ]
    ```

---

#### 2. Retrieve a Single User

*   **Endpoint:** `GET /users/{id}`
*   **Description:** Fetches a single user by their ID.
*   **Success Response (`200 OK`):**
    ```json
    {
        "id": 1,
        "name": "Adam",
        "date": "1990-10-20"
    }
    ```
*   **Error Response (`404 Not Found`):** If the user with the specified ID does not exist.
    ```json
    {
        "timestamp": "2023-10-27T10:30:00.123456",
        "message": "User not found with id: 1",
        "details": "uri=/users/1"
    }
    ```

---

#### 3. Create a New User

*   **Endpoint:** `POST /users`
*   **Description:** Creates a new user. The `id` is auto-generated.
*   **Request Body:**
    ```json
    {
        "name": "Suman",
        "date": "2000-01-01"
    }
    ```
*   **Success Response (`201 Created`):** The response will include a `Location` header with the URL of the newly created resource, e.g., `http://localhost:8080/users/4`.

*   **Validation Error Response (`400 Bad Request`):** If `name` has fewer than 2 characters or `date` is in the future.
    ```json
    {
        "timestamp": "2023-10-27T10:35:00.123456",
        "message": "Total Errors:1 First Error:Name should have atleast 2 characters",
        "details": "uri=/users"
    }
    ```

---

#### 4. Delete a User

*   **Endpoint:** `DELETE /users/{id}`
*   **Description:** Deletes a user by their ID.
*   **Success Response (`200 OK`):** No response body.
*   **Error Response (`404 Not Found`):** If the user with the specified ID does not exist.