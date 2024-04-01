# spring-boot-rest-api
Simple  REST API using spring boot to do CRUD operations

# *Employee Management REST API*
This project is a simple REST API built using Spring Boot to perform CRUD operations on an employee table in a H2 in-memory database. It also includes implementations for simple validations and exception handling.

## Features
1. CRUD Operations: The API provides endpoints to perform the following CRUD operations on employee data:
  - Retrieve all employees
  - Retrieve a specific employee by ID
  - Add a new employee
  - Update an existing employee
  - Delete an employee

2. H2 In-Memory Database: The API is integrated with an H2 in-memory database, allowing for lightweight and efficient data storage and retrieval.

3. Simple Validations: Basic validations are implemented to ensure data integrity and consistency. For example, validations may include checking for required fields, valid email formats, or numeric ranges.

4. Exception Handling: Exception handling is implemented to gracefully handle errors and provide informative error responses to clients.

## API Endpoints

### Retrieve All Employees
- **URL:** `/employees/all`
- **Method:** `GET`
- **Description:** Retrieves a list of all employees.

### Retrieve Employee by ID

- **URL:** `/api/employees/{id}`
- **Method:** `GET`
- **Description:** Retrieves a specific employee by their ID.

### Add New Employee

- **URL:** `/api/employees`
- **Method:** `POST`
- **Description:** Adds a new employee to the database.
- **Request Body:**
  ```json
  {
    "id": 1,
    "firstName" : "Jake",
    "lastName"  : "Smith",
    "dob"   : "2000-05-20",
    "designation"   : "Developer",
    "phoneNumber"   : "1234567890",
    "email" :   "jake.smith@demo.com"
  }

### Update Employee

- **URL:** `/api/employees`
- **Method:** `PUT`
- **Description:** Updates an employee in the database.
- **Request Body:**
  ```json
  {
    "id": 1,
    "firstName" : "Jake",
    "lastName"  : "Smith",
    "dob"   : "2000-05-20",
    "designation"   : "Developer",
    "phoneNumber"   : "1234567890",
    "email" :   "jake.smith@demo.com",
    "address" : "NY"
  }

### Delete Employee by ID

- **URL:** `/api/employees/{id}`
- **Method:** `DELETE`
- **Description:** Deletes a specific employee by their ID.


  

