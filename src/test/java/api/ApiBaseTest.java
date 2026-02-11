package com.Ana.framework.api;

import com.Ana.framework.config.Config;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public abstract class ApiBaseTest {

    private static com.Ana.framework.api.ApiTestUser VALID_USER;

    @BeforeClass(alwaysRun = true)
    public void apiSetup() {
        RestAssured.baseURI = Config.apiBaseUrl();
        RestAssured.filters(new AllureRestAssured()); // request/response attached to Allure

        // Create a valid user once for the whole API run
        if (VALID_USER == null) {
            VALID_USER = com.Ana.framework.api.ApiUserFactory.createFreshUser();
        }
    }

    protected com.Ana.framework.api.ApiTestUser validUser() {
        return VALID_USER;
    }
}
