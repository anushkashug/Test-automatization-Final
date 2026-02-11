package com.Ana.framework.ui.pages.;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductDetailsPage extends BasePage {

    private final By productName = By.cssSelector(".product-information h2");
    private final By category = By.xpath("//*[contains(text(),'Category')]");
    private final By price = By.xpath("//*[contains(text(),'Rs.')]");
    private final By availability = By.xpath("//*[contains(text(),'Availability')]");
    private final By condition = By.xpath("//*[contains(text(),'Condition')]");
    private final By brand = By.xpath("//*[contains(text(),'Brand')]");

    @Step("Verify product detail fields are visible")
    public ProductDetailsPage verifyDetailsVisible() {
        shouldBeVisible(productName);
        shouldBeVisible(category);
        shouldBeVisible(price);
        shouldBeVisible(availability);
        shouldBeVisible(condition);
        shouldBeVisible(brand);
        return this;
    }
}
