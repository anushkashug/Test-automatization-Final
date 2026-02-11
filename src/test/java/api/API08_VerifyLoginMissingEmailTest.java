package com.Ana.tests.api;

import com.Ana.framework.api.ApiBaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class API08_VerifyLoginMissingEmailTest extends ApiBaseTest {

    @Test
    public void verifyLogin_missingEmail_shouldReturn400() {
        given()
                .contentType(ContentType.URLENC)
                .formParam("password", "123456")
                .when()
                .post("/api/verifyLogin")
                .then()
                .statusCode(400)
                .body(containsString("email or password parameter is missing"));
    }
}
