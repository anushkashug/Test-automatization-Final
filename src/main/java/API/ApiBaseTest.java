package com.Ana.framework.api;

import com.Ana.framework.config.Config;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.testng.annotations.BeforeClass;

public abstract class ApiBaseTest {
    @BeforeClass(alwaysRun = true)
    public static void apiSetup() {
        RestAssured.baseURI = Config.apiBaseUrl();
        RestAssured.filters(new AllureRestAssured()); // attaches request/response to Allure
    }
}
