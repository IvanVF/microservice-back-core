# microservice-back-core

Bicycle shop back core API.

## Heroku address: 
https://bicycle-shop-back-core.herokuapp.com/ 
must show page with string "Microservice back core works!".

### Technologies Stack: 
Java, Spring, Postgres, Liquibase, Spring-Data-Jpa, Lombok.

### Chek work 
CheckAliveController, address: "/". Return "Microservice back core works!".

### Docker commands
docker build -t back .
docker run -p 8341:8341 -e SPRING_DATASOURCE_URL=jdbc:postgresql://172.22.112.1:5432/db_microservice -d --name back back


