# Human Resources Management System (HRMS) Application built using SpringBoot and Spring Cloud

##### Refactoring the whole project again with latest version.

## Introduction:
This is a HRMS module for ERP system. The module provides opportunities for HR department to manage employees and job-related openings in the organization, such as view the list of all employee, search the job applicant by its id, make changes to the job posted on the organization's portal, managing the payroll of the employee.
The system is primarily designed to properly organize the work of the department, speed up processes of hiring employees or opening necessary vacancies for the organization etc.
In this project, only the back-end of the system is going to be implemented, although the front-end was included while designing of entire system.

## Application Architecture Diagram:
(The application architecture diagram will be posted soon)

## Data Model Diagram:
(The data model diagram will be posted soon)

## Services in the project:
Each service is a separate microservice in the application.
1. service-registration
2. api-gateway-authentication-service
3. employee-service 
4. recruitment-service 
5. payroll-processing-service 
6. attendance-tracking-service 
7. hr-queries-service 
8. misc-service
## Ports used by different mirco-services:
1. service-registration : **8761**
2. api-gateway-authentication-service : **8080**
3. employee-service : **8100**
4. recruitment-service : **8200**
5. payroll-processing-service : **8300**
6. attendance-tracking-service : **8400**
7. hr-queries-service : **8500**
8. misc-service : **8600**
## APIs used in the project:
(Currently in development. Will be updated once the development is completed.)
## Tech Stack used in the project:
1. Java 21
2. Spring 6
3. Spring Boot 3
4. Spring Security
5. Spring Cloud
6. Spring Batch
7. Couchbase/MongoDB
8. MySQL database 
9. Lombok