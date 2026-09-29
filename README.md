# Student Course Management System

A backend application built using Java and Spring Boot to manage student information through REST APIs and a MySQL database.

The application provides APIs to create, retrieve, update, and delete student records. It follows a Controller-Service-Repository architecture and uses Spring Data JPA and Hibernate for database communication.

## Architecture

```text
                    REST API Request
                           |
                           v
                      Postman / Client
                           |
                           v
                  +-------------------+
                  | StudentController |
                  +-------------------+
                           |
                           v
                  +-------------------+
                  |   StudentService |
                  +-------------------+
                           |
                           v
                  +-------------------+
                  | StudentRepository |
                  +-------------------+
                           |
                           v
                 Spring Data JPA
                           |
                           v
                      Hibernate
                           |
                           v
                    +-------------+
                    |    MySQL    |
                    | student_    |
                    | management  |
                    +-------------+
```

## Tech Stack

* Java 17
* Spring Boot
* Spring Web / REST API
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Postman
* Git
* GitHub
* Visual Studio Code

## Project Features

The application provides the following student management operations:

* Create a new student
* View all students
* View a student by ID
* Update student information
* Delete a student
* Handle requests for students that do not exist
* Store student information permanently in MySQL

## Student Data

Each student record contains:

* Student ID
* Name
* Email
* Course

Example:

```text
ID      Name       Email                  Course
---------------------------------------------------------------
2       Blessy     blessy@gmail.com       Artificial Intelligence
```

## REST API Endpoints

| HTTP Method | Endpoint         | Description                |
| ----------- | ---------------- | -------------------------- |
| GET         | `/students`      | Get all students           |
| GET         | `/students/{id}` | Get student by ID          |
| POST        | `/students`      | Add a new student          |
| PUT         | `/students/{id}` | Update an existing student |
| DELETE      | `/students/{id}` | Delete a student           |

## API Operations

### GET - Get All Students

Retrieves all student records stored in the MySQL database.

```http
GET /students
```

Example response:

```json
[
    {
        "id": 2,
        "name": "Blessy",
        "email": "blessy@gmail.com",
        "course": "Artificial Intelligence and Data Science"
    }
]
```

### GET - Get Student by ID

Retrieves a specific student using the student ID.

```http
GET /students/2
```

Example response:

```json
{
    "id": 2,
    "name": "Blessy",
    "email": "blessy@gmail.com",
    "course": "Artificial Intelligence and Data Science"
}
```

### POST - Add Student

Creates a new student record.

```http
POST /students
```

Request body:

```json
{
    "id": 4,
    "name": "Blessy Test",
    "email": "blesstest@gmail.com",
    "course": "Artificial Intelligence"
}
```

The new student is stored in the MySQL database.

### PUT - Update Student

Updates an existing student's information.

```http
PUT /students/4
```

Request body:

```json
{
    "name": "Blessy Updated",
    "email": "blessyupdated@gmail.com",
    "course": "Cloud Computing"
}
```

The existing record is updated in the database.

### DELETE - Delete Student

Deletes a student using the student ID.

```http
DELETE /students/4
```

Example response:

```text
Student deleted successfully
```

## Error Handling

The application handles requests for students that do not exist.

For example:

```http
GET /students/999
```

returns:

```text
404 Not Found
```

with a message indicating that the student was not found.

This error handling is implemented in the Service layer using `ResponseStatusException`.

## Database

The application uses MySQL for persistent data storage.

Database:

```text
student_management
```

Table:

```text
students
```

Table structure:

```text
+-------+--------------+
| Field | Type         |
+-------+--------------+
| id    | BIGINT       |
| name  | VARCHAR(100)  |
| email | VARCHAR(150)  |
| course| VARCHAR(100)  |
+-------+--------------+
```

Spring Data JPA and Hibernate are used to communicate between the Spring Boot application and MySQL.

## JPA Entity

The `Student` class is mapped to the `students` database table using JPA annotations.

```text
Student
   |
   +-- id
   +-- name
   +-- email
   +-- course
```

The `id` field is used as the primary key.

## Project Structure

```text
studentcoursemanagement/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── vineela/
│   │   │           └── studentcoursemanagement/
│   │   │               │
│   │   │               ├── controller/
│   │   │               │   ├── HomeController.java
│   │   │               │   └── StudentController.java
│   │   │               │
│   │   │               ├── model/
│   │   │               │   └── Student.java
│   │   │               │
│   │   │               ├── repository/
│   │   │               │   └── StudentRepository.java
│   │   │               │
│   │   │               ├── service/
│   │   │               │   └── StudentService.java
│   │   │               │
│   │   │               └── StudentcoursemanagementApplication.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-example.properties
│   │
│   └── test/
│       └── java/
│
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Application Flow

When a client sends a request, it follows this flow:

```text
Client
  |
  v
StudentController
  |
  | HTTP Request
  v
StudentService
  |
  | Business Logic
  v
StudentRepository
  |
  | JPA
  v
Hibernate
  |
  | SQL
  v
MySQL
```

For example, when adding a student:

```text
POST /students
       |
       v
StudentController
       |
       v
StudentService
       |
       v
StudentRepository
       |
       v
MySQL
```

## Separation of Responsibilities

### Controller

The Controller handles HTTP requests and responses.

```text
StudentController
```

It provides the REST endpoints for student operations.

### Service

The Service layer contains the application logic.

```text
StudentService
```

It handles operations such as:

* Finding students
* Adding students
* Updating students
* Deleting students
* Handling student-not-found errors

### Repository

The Repository communicates with the database.

```text
StudentRepository
```

It extends:

```java
JpaRepository<Student, Long>
```

This provides database operations without writing SQL for every CRUD operation.

## Testing

The REST APIs were tested using Postman.

The following operations were tested:

* GET all students
* GET student by ID
* POST student
* PUT student
* DELETE student
* GET request for a non-existing student

Database records were also verified using MySQL.

## Build and Run

Clone the repository:

```bash
git clone https://github.com/Vineela9999/student-course-management.git
```

Move into the project directory:

```bash
cd student-course-management
```

Build the project:

```bash
.\mvnw.cmd clean compile
```

Run the application:

```bash
.\mvnw.cmd spring-boot:run
```

The application runs on:

```text
http://localhost:8080
```

## Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE student_management;
```

Create the students table:

```sql
CREATE TABLE students (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(150),
    course VARCHAR(100)
);
```

Configure the database connection in the application's local configuration.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_management
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

**Do not commit real database passwords or credentials to GitHub.**

## Key Engineering Concepts Demonstrated

* REST API development
* HTTP methods
* CRUD operations
* Spring Boot application development
* Controller-Service-Repository architecture
* Dependency Injection
* Spring Data JPA
* Hibernate ORM
* MySQL database integration
* Entity mapping
* Database persistence
* Exception handling
* API testing using Postman
* Maven project management
* Git version control
* GitHub repository management

## What I Learned

Through this project, I learned how to:

* Build REST APIs using Spring Boot
* Connect a Java application with MySQL
* Use Spring Data JPA and Hibernate
* Implement CRUD operations
* Separate application responsibilities using layers
* Handle errors for missing records
* Test APIs using Postman
* Use Git for version control
* Upload and manage a project using GitHub

## Project Outcome

The Student Course Management System successfully provides a REST-based backend for managing student information.

The project demonstrates the complete flow from:

```text
REST API Request
       ↓
Spring Boot
       ↓
Controller
       ↓
Service
       ↓
Repository
       ↓
JPA / Hibernate
       ↓
MySQL
```

The project gave me practical experience in backend development, database integration, REST API design, testing, and version control.

## Author

**Kamalakunta Vineela**

GitHub:

https://github.com/Vineela9999
