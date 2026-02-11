package com.Ana.framework.ui.pages.;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SignupFormPage extends BasePage {

    private final By titleMr = By.id("id_gender1");
    private final By password = By.id("password");

    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By address = By.id("address1");
    private final By country = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobile = By.id("mobile_number");

    private final By createAccountBtn = By.cssSelector("button[data-qa='create-account']");
    private final By accountCreated = By.xpath("//*[contains(text(),'ACCOUNT CREATED')]");

    @Step("Fill minimal signup form and create account")
    public AccountCreatedPage createAccount(String pass) {
        click(titleMr);
        type(password, pass);

        type(firstName, "Test");
        type(lastName, "User");
        type(address, "Tbilisi");
        // country is a select, but sendKeys works too
        type(country, "Canada");
        type(state, "State");
        type(city, "City");
        type(zipcode, "0101");
        type(mobile, "555123456");

        click(createAccountBtn);
        shouldBeVisible(accountCreated);
        return new AccountCreatedPage();
    }
}
