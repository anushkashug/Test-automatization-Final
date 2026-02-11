package com.Ana.tests.api;

import com.Ana.framework.api.ApiBaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class API04_PutToBrandsListTest extends ApiBaseTest {

    @Test
    public void putToBrandsList_shouldReturn405() {
        given()
                .when()
                .put("/api/brandsList")
                .then()
                .statusCode(405)
                .body(containsString("This request method is not supported"));
    }
}
