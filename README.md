[//]: # (# Car Rental Auth Service)

[//]: # ()
[//]: # (This service is responsible for authentication of users in the Car Rental application. It uses Keycloak as an authentication server.)

[//]: # ()
[//]: # (## Getting Started)

[//]: # ()
[//]: # (### Prerequisites)

[//]: # ()
[//]: # (Before running this service, make sure you have installed:)

[//]: # ()
[//]: # (- Java 17 or higher)

[//]: # (- Maven)

[//]: # (- Keycloak server)

[//]: # ()
[//]: # (### Installing)

[//]: # ()
[//]: # (1. Clone the repository:)

[//]: # ()
[//]: # (```git clone https://github.com/your_username/car-rental-auth-service.git```)

[//]: # ()
[//]: # ()
[//]: # (2. Navigate to the cloned repository:)

[//]: # ()
[//]: # (```cd car-rental-auth-service```)

[//]: # ()
[//]: # (3. Build the project:)

[//]: # ()
[//]: # (```mvn clean install```)

[//]: # ()
[//]: # (### Configuration)

[//]: # ()
[//]: # (Configuration of this service is done through application*.yml files, located in the `src/main/resources` directory.)

[//]: # ()
[//]: # (#### `application.yml`)

[//]: # ()
[//]: # (This file contains general configuration options for the service.)

[//]: # ()
[//]: # (#### `keycloak.yml`)

[//]: # ()
[//]: # (This file contains configuration options for the Keycloak authentication server.)

[//]: # ()
[//]: # (### Usage)

[//]: # ()
[//]: # (To use this service, make HTTP requests to the provided endpoints, with the required authentication and authorization headers.)

[//]: # ()
[//]: # (#### Authentication)

[//]: # ()
[//]: # (This service uses Keycloak as an authentication server. To authenticate a user, obtain a JWT access token from the Keycloak server, and include it in the `Authorization` header of each HTTP request. The token should be in the format `Bearer <access_token>`.)

[//]: # ()
[//]: # (#### Authorization)

[//]: # ()
[//]: # (This service uses Spring Security for authorization. To access certain endpoints, a user must have the required role&#40;s&#41; specified in the table above. The role&#40;s&#41; should be included in the `Authorization` header of each HTTP request, in the format `Bearer <access_token>`. The JWT access token obtained from the Keycloak server contains the required role information.)

[//]: # ()
[//]: # (### Built With)

[//]: # ()
[//]: # (- [Spring Boot]&#40;https://spring.io/projects/spring-boot&#41; - Framework for building Spring applications)

[//]: # (- [Spring Security]&#40;https://spring.io/projects/spring-security&#41; - Framework for authentication and authorization)

[//]: # (- [Keycloak]&#40;https://www.keycloak.org/&#41; - Open source authentication server)

[//]: # (- [Maven]&#40;https://maven.apache.org/&#41; - Build automation tool)

[//]: # ()
[//]: # (### Authors)

[//]: # ()
[//]: # (- Piotrek Poleszak - Initial work - poleszak@proton.me)