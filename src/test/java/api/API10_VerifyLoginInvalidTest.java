package com.Ana.tests.api;

import com.Ana.framework.api.ApiBaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class API10_VerifyLoginInvalidTest extends ApiBaseTest {

    @Test
    public void verifyLogin_invalid_shouldReturn404() {
        given()
                .contentType(ContentType.URLENC)
                .formParam("email", "invalid_" + System.currentTimeMillis() + "@example.com")
                .formParam("password", "wrongpass")
                .when()
                .post("/api/verifyLogin")
                .then()
                .statusCode(404)
                .body(containsString("User not found"));
    }
}
