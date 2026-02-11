package com.Ana.framework.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AccountCreatedPage extends BasePage {

    private final By continueBtn = By.cssSelector("a[data-qa='continue-button'], a.btn.btn-primary");

    @Step("Click Continue after account created")
    public void continueToHome() {
        click(continueBtn);
    }
}
