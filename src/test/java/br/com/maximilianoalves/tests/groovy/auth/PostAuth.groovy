package br.com.maximilianoalves.tests.groovy.auth

import br.com.maximilianoalves.tests.groovy.BaseTest
import org.json.JSONException
import org.json.JSONObject

import static io.restassured.RestAssured.given

class PostAuth extends BaseTest {

    String getBearerToken() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("email", "admin@user.com.br");
            jsonObject.put("password", "admin");
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }

        String token = given()
                .header("Content-type", "application/json")
                .when()
                .body(jsonObject.toString())
                .post("api/v1/auth/authenticate")
                .then()
                .statusCode(200).extract().path("token");

        return "Bearer " + token;
    }
}
