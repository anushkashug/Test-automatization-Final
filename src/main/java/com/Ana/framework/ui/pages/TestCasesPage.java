package com.Ana.framework.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TestCasesPage extends BasePage {

    private final By testCasesHeader = By.xpath("//*[contains(text(),'Test Cases')]");

    @Step("Verify Test Cases page opened")
    public TestCasesPage verifyOpened() {
        shouldBeVisible(testCasesHeader);
        return this;
    }
}
