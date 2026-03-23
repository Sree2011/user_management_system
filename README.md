<script src="https://cdn.jsdelivr.net/npm/mermaid@11/dist/mermaid.min.js"></script>
<script>
  mermaid.initialize({ startOnLoad: true, theme: 'default' });
</script>

# User Management System

A backend application built with **Spring Boot**, **Spring Data JPA**, and **MySQL** to manage users and their roles.  
This project demonstrates clean architecture, centralized exception handling, and professional API documentation.

---

## 📌 Features
- **Layered Architecture**: Controller, Service, Repository, DTO, Model, Utility, and Exception packages.
- **Persistence**: Integrated Spring Data JPA with MySQL.
- **Error Handling**: Centralized exception management using `@ControllerAdvice` and custom exceptions.
- **RESTful APIs**: Nested endpoints (e.g., `/users/{id}/roles`) for user-role management.
- **API Documentation**: Swagger annotations for clear and interactive API docs.
- **Maintainability**: Lombok used to reduce boilerplate and improve readability.

---

## Architecture Diagram

<pre class="mermaid">
architecture-beta
    group backend(cloud)[User Management System]

    service client(actor)[Client] in backend
    service controller(control)[Controller] in backend
    service service_svc(control)[Service] in backend
    service dto(entity)[DTO] in backend
    service repository(database)[Repository] in backend
    service db(database)[Database] in backend

    client:R --> L:controller
    controller:R --> L:service_svc
    service_svc:R --> L:dto
    dto:R --> L:repository
    repository:R --> L:db
    db:L --> R:repository
    repository:L --> R:dto
    dto:L --> R:service_svc
    service_svc:L --> R:controller
    controller:L --> R:client

</pre>

## Entity Diagram

<pre class="mermaid">
erDiagram
    USER {
        int user_id PK
        string name
        string email
    }

    PROJECT {
        int project_id PK
        string name
        string description
        datetime created_at
        int owner_id FK
    }

    TASK {
        int task_id PK
        string title
        string description
        string status
        string priority
        datetime due_date
        int project_id FK
        int assigned_to FK
    }

    COMMENT {
        int comment_id PK
        string content
        datetime created_at
        int task_id FK
        int author_id FK
    }

    USER ||--o{ PROJECT : "owns"
    PROJECT ||--o{ TASK : "has"
    USER ||--o{ TASK : "assigned"
    TASK ||--o{ COMMENT : "has"
    USER ||--o{ COMMENT : "authors"

</pre>

## 🚀 Future Enhancements
- Add **unit and integration tests** with **SonarQube coverage reports**.
- Implement **authentication & authorization** using **Spring Security + JWT**.
- Extend role-based access control for fine-grained permissions.

---

## 🛠️ Technologies Used
- Java  
- Spring Boot  
- Spring Data JPA  
- MySQL  
- Lombok  
- Swagger  

---


## 📖 API Examples
- **Get User by ID**  
  `GET /users/{id}`  

- **Assign Role to User**  
  `POST /users/{id}/roles`  

---

## 🔗 Repository
[GitHub - User Management System](https://github.com/Sree2011/user_management_system)


