package com.Ana.framework.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By subscriptionTitle = By.xpath("//*[contains(text(),'SUBSCRIPTION')]");
    private final By subscriptionEmail = By.id("susbscribe_email");
    private final By subscriptionArrowBtn = By.id("subscribe");
    private final By subscriptionSuccess = By.xpath("//*[contains(text(),'You have been successfully subscribed!')]");

    @Step("Subscribe from cart footer")
    public CartPage subscribe(String email) {
        scrollToBottom();
        shouldBeVisible(subscriptionTitle);
        type(subscriptionEmail, email);
        click(subscriptionArrowBtn);
        shouldBeVisible(subscriptionSuccess);
        return this;
    }
}
