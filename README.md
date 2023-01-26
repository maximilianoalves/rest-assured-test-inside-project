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
