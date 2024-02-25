# Employee Management API with Java Spring Boot

## Overview

The Employee Management API simplifies employee-related activities. For detailed information, refer to the [Features](#features) section.

## Test API here

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://god.gw.postman.com/run-collection/28660393-1084e843-982c-4c4c-b8b2-ac0c5bd83396?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D28660393-1084e843-982c-4c4c-b8b2-ac0c5bd83396%26entityType%3Dcollection%26workspaceId%3D11c0cfed-e67e-419c-80a9-ee99eb5dd5c6)

## Requirements

1. **Java Development Kit (JDK) 17 or above:**
    - Ensure that you have Java Development Kit version 17 or a later version installed on your system.

2. **MySQL Database:**
    - Utilize a local MySQL instance or connect to a remote MySQL server.

## How to Run

1. Clone the project repository from Git (if it's not already cloned).
2. Import the project into your favorite Java IDE (e.g., IntelliJ, Eclipse, etc.).
3. Build the project to resolve dependencies.

## Features

### Employee Management

| No. | Feature                 | Description                                     | Endpoint                        |
|----:|-------------------------|-------------------------------------------------|---------------------------------|
| 1.  | List All Employees      | Retrieve a list of all employees.               | `GET /employees`                |
| 2.  | Paginate Employees      | Paginate through employees.                     | `GET /employees/pages`          |
| 3.  | Get Employee Details    | Get details of a specific employee by ID.       | `GET /employees/{id}`           |
| 4.  | Get Employees by Dept   | Get employees belonging to a specific department| `GET /employees/department/{id}`|
| 5.  | Add Employee            | Add a new employee.                             | `POST /employees/add`           |
| 6.  | Search Employees        | Search for employees by name.                   | `GET /employees/search`         |
| 7.  | Update Employee         | Update details of an existing employee.         | `PUT /employees/update/{id}`    |
| 8.  | Delete Employee         | Delete an employee by ID.                        | `DELETE /employees/delete/{id}` |

### Department Management

| No. | Feature                 | Description                                     | Endpoint                        |
|----:|-------------------------|-------------------------------------------------|---------------------------------|
| 1.  | List All Departments    | Retrieve a list of all departments.             | `GET /departments`               |
| 2.  | Paginate Departments    | Paginate through departments.                   | `GET /departments/pages`         |
| 3.  | Get Department Details  | Get details of a specific department by ID.     | `GET /departments/{id}`          |
| 4.  | Add Department          | Add a new department.                           | `POST /departments/add`          |
| 5.  | Update Department       | Update details of an existing department.       | `PUT /departments/update/{id}`   |
| 6.  | Delete Department       | Delete a department by ID.                      | `DELETE /departments/delete/{id}`|
| 7.  | Search Departments     | Search for departments by name.                 | `GET /departments/search`        |

