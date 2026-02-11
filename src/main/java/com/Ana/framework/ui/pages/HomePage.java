package com.Ana.framework.ui.pages;

import com.Ana.framework.config.Config;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By signupLoginBtn = By.cssSelector("a[href='/login']");
    private final By testCasesBtn = By.cssSelector("a[href='/test_cases']");
    private final By productsBtn = By.cssSelector("a[href='/products']");
    private final By cartBtn = By.cssSelector("a[href='/view_cart']");

    // Subscription (footer)
    private final By subscriptionTitle = By.xpath("//*[contains(text(),'SUBSCRIPTION')]");
    private final By subscriptionEmail = By.id("susbscribe_email");
    private final By subscriptionArrowBtn = By.id("subscribe");
    private final By subscriptionSuccess = By.xpath("//*[contains(text(),'You have been successfully subscribed!')]");

    @Step("Open home page")
    public HomePage open() {
        driver.get(Config.uiBaseUrl());
        return this;
    }

    @Step("Go to Signup/Login")
    public SignupLoginPage goToSignupLogin() {
        click(signupLoginBtn);
        return new SignupLoginPage();
    }

    @Step("Go to Test Cases page")
    public TestCasesPage goToTestCases() {
        click(testCasesBtn);
        return new TestCasesPage();
    }

    @Step("Go to Products page")
    public ProductsPage goToProducts() {
        click(productsBtn);
        return new ProductsPage();
    }

    @Step("Go to Cart page")
    public CartPage goToCart() {
        click(cartBtn);
        return new CartPage();
    }

    @Step("Subscribe from home footer")
    public HomePage subscribe(String email) {
        scrollToBottom();
        shouldBeVisible(subscriptionTitle);
        type(subscriptionEmail, email);
        click(subscriptionArrowBtn);
        shouldBeVisible(subscriptionSuccess);
        return this;
    }
}
