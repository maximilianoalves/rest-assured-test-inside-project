package br.com.maximilianoalves.tests.groovy.tutorials

import br.com.maximilianoalves.tests.groovy.BaseTest
import br.com.maximilianoalves.tests.java.auth.PostAuth
import org.junit.Test
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan

class GetTutorials extends BaseTest {

    PostAuth postAuth = new PostAuth();

    @Test
    void "should be returned all tutorials"() {
        given: "set up request"
        def request = given().header("Authorization", postAuth.bearerToken)

        when: "get all tutorials"
        def response = request.when().get("api/v1/tutorials")

        then: "should be 200 okey, response have content"
        response.then()
            .statusCode(200).body("results.size()", greaterThan(0));
    }
}
