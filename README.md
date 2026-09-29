# Student Course Management System 🎓

A backend REST API application for managing student information using Java, Spring Boot, MySQL, Spring Data JPA, and Hibernate.

## 🚀 Features

* ✅ Add a new student
* ✅ Get all students
* ✅ Get a student by ID
* ✅ Update student information
* ✅ Delete a student
* ✅ Store student data in MySQL
* ✅ RESTful API endpoints
* ✅ 404 error handling for students that do not exist
* ✅ Controller-Service-Repository architecture

## 🛠️ Technologies Used

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Postman
* Git & GitHub
* VS Code

## 🏗️ Project Architecture

```text
Client / Postman
       ↓
StudentController
       ↓
StudentService
       ↓
StudentRepository
       ↓
Spring Data JPA / Hibernate
       ↓
MySQL Database
```

### Layers

**Controller**

Handles HTTP requests such as GET, POST, PUT, and DELETE.

**Service**

Contains the business logic of the application.

**Repository**

Communicates with the MySQL database using Spring Data JPA.

**Model**

Represents the Student entity stored in the database.

## 📂 Project Structure

```text
studentcoursemanagement
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── vineela
│   │   │           └── studentcoursemanagement
│   │   │               ├── controller
│   │   │               │   ├── HomeController.java
│   │   │               │   └── StudentController.java
│   │   │               │
│   │   │               ├── model
│   │   │               │   └── Student.java
│   │   │               │
│   │   │               ├── repository
│   │   │               │   └── StudentRepository.java
│   │   │               │
│   │   │               ├── service
│   │   │               │   └── StudentService.java
│   │   │               │
│   │   │               └── StudentcoursemanagementApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
```

## 🗄️ Database

The application uses MySQL.

### Database

```text
student_management
```

### Table

```text
students
```

### Student fields

| Field  | Type    |
| ------ | ------- |
| id     | BIGINT  |
| name   | VARCHAR |
| email  | VARCHAR |
| course | VARCHAR |

## 🌐 REST API Endpoints

### Get all students

```http
GET /students
```

Returns all students stored in the database.

### Get student by ID

```http
GET /students/{id}
```

Example:

```http
GET /students/2
```

### Add a student

```http
POST /students
```

Example request:

```json
{
    "id": 4,
    "name": "Blessy",
    "email": "blessy@gmail.com",
    "course": "Artificial Intelligence and Data Science"
}
```

### Update a student

```http
PUT /students/{id}
```

Example:

```http
PUT /students/4
```

Example request:

```json
{
    "name": "Blessy Updated",
    "email": "blessyupdated@gmail.com",
    "course": "Cloud Computing"
}
```

### Delete a student

```http
DELETE /students/{id}
```

Example:

```http
DELETE /students/4
```

## ❌ Error Handling

If a student ID does not exist, the application returns:

```text
404 NOT_FOUND
```

For example:

```http
GET /students/999
```

The application responds with a student-not-found error.

## 📮 API Testing

The REST APIs were tested using Postman.

The following operations were tested:

```text
POST  → Create student
GET   → Retrieve students
GET   → Retrieve student by ID
PUT   → Update student
DELETE → Delete student
```

## ⚙️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/Vineela9999/student-course-management.git
```

### 2. Open the project

Open the project in VS Code or another Java IDE.

### 3. Configure MySQL

Create the database:

```sql
CREATE DATABASE student_management;
```

Configure the database connection in:

```text
src/main/resources/application.properties
```

Do not commit your real database password to GitHub.

### 4. Run the application

Using Maven Wrapper:

```bash
.\mvnw.cmd spring-boot:run
```

The application runs on:

```text
http://localhost:8080
```

## 🔍 Application Test

Open:

```text
http://localhost:8080/
```

Expected response:

```text
Student Course Management Application is running!
```

## 📸 API Demo

Screenshots of the Postman API testing can be added here.

### GET All Students

*Add screenshot here.*

### POST Student

*Add screenshot here.*

### PUT Student

*Add screenshot here.*

### DELETE Student

*Add screenshot here.*

## 🎯 What I Learned

Through this project, I learned:

* How Spring Boot applications are structured
* How REST APIs work
* How HTTP methods are used
* How Controller, Service, and Repository layers work together
* How Spring Data JPA communicates with a database
* How Hibernate handles persistence
* How to connect Spring Boot with MySQL
* How to test APIs using Postman
* How to handle REST API errors
* How to use Git and GitHub for version control

## 🎓 Interview Explanation

> My project is a Student Course Management System developed using Java, Spring Boot, REST APIs, and MySQL. It allows users to add, view, update, and delete student information. I used a Controller-Service-Repository architecture. The Controller handles HTTP requests, the Service contains the business logic, and the Repository communicates with MySQL using Spring Data JPA and Hibernate. I tested the REST APIs using Postman and implemented error handling for students that do not exist.

## 👩‍💻 Author

**Kamalakunta Vineela**

GitHub:
https://github.com/Vineela9999

---

⭐ If you find this project useful, feel free to explore the repository.
