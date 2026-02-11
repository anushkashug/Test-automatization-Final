package com.Ana.tests.api;

import com.Ana.framework.api.ApiBaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class API03_GetAllBrandsTest extends ApiBaseTest {

    @Test
    public void getAllBrandsList() {
        given()
                .when()
                .get("/api/brandsList")
                .then()
                .statusCode(200)
                .body("brands", is(notNullValue()));
    }
}
