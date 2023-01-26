package br.com.maximilianoalves.tests;

import br.com.maximilianoalves.BaseTests;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetTutorials extends BaseTests {

    @Test
    public void shouldBeReturnedAllTutorials() {
        given()
            .when()
                .get("api/tutorials")
            .then()
                .statusCode(200);
    }
}
