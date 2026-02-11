package com.Ana.tests.api;

import com.Ana.framework.api.ApiBaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class API01_GetAllProductsTest extends ApiBaseTest {

    @Test
    public void getAllProductsList() {
        given()
                .when()
                .get("/api/productsList")
                .then()
                .statusCode(200)
                .body("products", is(notNullValue()));
    }
}
