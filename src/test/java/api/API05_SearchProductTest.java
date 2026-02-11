package com.Ana.tests.api;

import com.Ana.framework.api.ApiBaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class API05_SearchProductTest extends ApiBaseTest {

    @Test
    public void searchProduct_shouldReturn200() {
        given()
                .contentType(ContentType.URLENC)
                .formParam("search_product", "top")
                .when()
                .post("/api/searchProduct")
                .then()
                .statusCode(200)
                .body("products", is(notNullValue()));
    }
}
