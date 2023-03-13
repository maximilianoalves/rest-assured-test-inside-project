<h1 align="center">Using the rest assured inside of spring boot project</h1>

<b>Para acessar a versão em Português do Brasil, basta clicar [aqui](/docs/README-pt_BR.md)! :brazil:</b>

<p>This project was created for example of structure for api testing using Java and Rest-Assured inside a springboot project. </p>

## Technologies and tools used:
- [Java](https://www.java.com/pt-BR/)
- [Rest-Assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured)
- [Swagger](https://swagger.io/)
- [Spring boot](https://spring.io/projects/spring-boot)
- [Junit 5](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)
- [Allure](https://docs.qameta.io/allure/#_junit_5)
- [Java faker](https://github.com/DiUS/java-faker)
- [H2Database](https://www.h2database.com/html/main.html)


## Run API.
``` mvn spring-boot:run ```
This command will be create the database in memory, add data inside the database and able access to endpoint. 

- API baseurl: localhost:8080/api/
- Swagger documentation: localhost:8080/api/swagger-ui.html

## Test Scenarios

- GET /tutorials: 
  - should be return with success all tutorials
    - check 200 status code
    - check schema object  
  - should be return NO CONTENT when the list is empty
    - dependencie: delete all tutorials before call GET /tutorials
    - check 204 status code
    - check empty body  
- GET /tutorials/{id}:  
  - should be return with success a single tutorial
    - check 200 status code
    - check schema object for one tutorial
  - should be return a error when put a nonexistance id.
    - check 404 not found status
    - check schema object for the error  
- DELETE /tutorials: 
  - should be deleted all tutorials with success
    - check 204 status code
    - check doesn't have body
  - should be return error when try delete all tutorials without tutorails registered
    - check 500 status code
    - check doesn't have body
- DELETE /tutorials/{id}:
  - should be deleted with success
    - check 204 status code
    - check doesn't have body
  - should be return error when try delete a tutorials with nonexistance id.
    - check 500 status code
    - schema error schema
