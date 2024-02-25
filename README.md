# Human Resources Management System (HRMS) Application built using SpringBoot and Spring Cloud
### Contributor : Swapnadeep Dutta


###### Currently, the project is in development stage.

## Introduction:
This is a HRMS module for ERP system. The module provides opportunities for HR department to manage employees and job-related openings in the organization, such as view the list of all employee, search the job applicant by its id, make changes to the job posted on the organization's portal, managing the payroll of the employee.
The system is primarily designed to properly organize the work of the department, speed up processes of hiring employees or opening necessary vacancies for the organization etc.
In this project, only the back-end of the system is going to be implemented, although the front-end was included while designing of entire system.

## Application Architecture Diagram:
(The application architecture diagram will be posted soon)

## Data Model Diagram:
(The data model diagram will be posted soon)

##To-dos in the project
* Spring Batch implementation for deleting the resume older than 90 days if the candidate's skill set does not match or the job posting is no longer valid.
* Authentication and Recruitment services yet to be designed.
* MQ designing and implementation for sending alerts to the candidate and HRs when the candidate is selected, on-boarded or rejected is still in pending stage.
## Services in the project:
Each service is a separate microservice in the application.
1. eureka-discovery-service
2. config-server
3. gateway-service
4. authentication-service
5. employee-service
6. recruitment-service
7. payroll-service
8. tax-service
9. department-service
10. hr-queries-service
11. recruitment-service
## Ports used by different mirco-services:
1. eureka-discovery-service : **8761**
2. config-server : **8000**
3. gateway-service : **8080**
4. authentication-service : **8100**
5. employee-service : **8200**
6. recruitment-service : **8300**
7. payroll-service : **8400**
8. tax-service : **8500**
9. department-service : **8600**
10. hr-queries-service : **8700**
11. recruitment-service : **8800**
## APIs used in the project:
(Currently in development. Will be updated once the development is completed.)
## Tech Stack used in the project:
1. Java 21
2. Spring 6
3. Spring Boot 3
4. Spring Security
5. Spring Data JPA
6. Spring Cloud
7. Spring Batch
8. RabbitMQ/Apache Kafka
9. MySQL database
10. Lombok