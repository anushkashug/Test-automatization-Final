package com.Ana.framework.core;

import com.Ana.framework.config.Config;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;

public abstract class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverFactory.createDriver(Config.headless());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            attachScreenshot();
        }
        DriverFactory.quitDriver();
    }

    @Attachment(value = "UI Screenshot (failure)", type = "image/png")
    public void attachScreenshot() {
        ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}