package br.com.maximilianoalves.tests.tutorials;

import br.com.maximilianoalves.BaseTests;
import br.com.maximilianoalves.tests.auth.PostAuth;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetTutorials extends BaseTests {

    PostAuth postAuth = new PostAuth();

    @Test
    public void shouldBeReturnedAllTutorials() {
        String bearerToken = postAuth.getBearerToken();

        given()
                .header("Authorization", bearerToken)
            .when()
                .get("api/v1/tutorials")
            .then()
                .statusCode(200);
    }
}
