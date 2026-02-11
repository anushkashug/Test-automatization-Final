package com.Ana.tests.api;

import com.Ana.framework.api.ApiBaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class API02_PostToProductsListTest extends ApiBaseTest {

    @Test
    public void postToProductsList_shouldReturn405() {
        given()
                .when()
                .post("/api/productsList")
                .then()
                .statusCode(405)
                .body(containsString("This request method is not supported"));
    }
}
