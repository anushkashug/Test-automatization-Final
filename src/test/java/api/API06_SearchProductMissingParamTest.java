package com.Ana.tests.api;

import com.Ana.framework.api.ApiBaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class API06_SearchProductMissingParamTest extends ApiBaseTest {

    @Test
    public void searchProduct_missingParam_shouldReturn400() {
        given()
                .when()
                .post("/api/searchProduct")
                .then()
                .statusCode(400)
                .body(containsString("search_product parameter is missing"));
    }
}
