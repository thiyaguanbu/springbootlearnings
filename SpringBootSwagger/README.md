# Spring Boot Swagger

## Spring Boot, MySQL, JPA, Hibernate Rest API Tutorial
This is sample application to demonstrate the Swagger and H2 Database -SpringBootSwagger application using Spring Boot, H2, JPA and Hibernate.	
## Requirements
1.	Java - 1.8.x
2.	Maven - 3.x.x
3.	H2 database
## Steps to Setup
1. Clone the application
git clone https://github.com/thiyaguanbu/springbootlearnings.git
2. Create Mysql database
create database notes_app
3. Change mysql username and password as per your installation
>	open src/main/resources/application.properties
>	change spring.datasource.username and spring.datasource.password as per your mysql installation
4. Build and run the app using maven
## mvn package
java -jar target/SpringBootSwagger-1.0.0.jar
Alternatively, you can run the app without packaging it using -
mvn spring-boot:run
The app will start running at http://localhost:8080.
## Explore Rest APIs
The app defines following CRUD APIs.
PRODUCT API
GET /product/list

POST /product/add

GET /product/{id}

PUT /product/update/{id}

DELETE /product/{id}
You can test them using postman or any other rest client.

