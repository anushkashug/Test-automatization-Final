package com.Ana.tests.api;

import com.Ana.framework.api.ApiBaseTest;
import com.Ana.framework.api.ApiTestUser;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class API07_VerifyLoginValidTest extends ApiBaseTest {

    @Test
    public void verifyLogin_valid_shouldReturn200() {
        ApiTestUser user = validUser();

        given()
                .contentType(ContentType.URLENC)
                .formParam("email", user.email)
                .formParam("password", user.password)
                .when()
                .post("/api/verifyLogin")
                .then()
                .statusCode(200)
                .body(containsString("User exists"));
    }
}
