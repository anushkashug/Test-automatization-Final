package com.Ana.framework.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SignupLoginPage extends BasePage {

    // Signup
    private final By signupName = By.name("name");
    private final By signupEmail = By.cssSelector("input[data-qa='signup-email']");
    private final By signupBtn = By.cssSelector("button[data-qa='signup-button']");
    private final By signupErrorExistingEmail = By.xpath("//*[contains(text(),'Email Address already exist')]");

    // Login
    private final By loginEmail = By.cssSelector("input[data-qa='login-email']");
    private final By loginPassword = By.cssSelector("input[data-qa='login-password']");
    private final By loginBtn = By.cssSelector("button[data-qa='login-button']");
    private final By loginError = By.xpath("//*[contains(text(),'Your email or password is incorrect')]");

    @Step("Start signup with name={name}, email={email}")
    public SignupFormPage startSignup(String name, String email) {
        type(signupName, name);
        type(signupEmail, email);
        click(signupBtn);
        return new SignupFormPage();
    }

    @Step("Try signup with existing email")
    public SignupLoginPage signupExpectExistingEmailError(String name, String email) {
        type(signupName, name);
        type(signupEmail, email);
        click(signupBtn);
        shouldBeVisible(signupErrorExistingEmail);
        return this;
    }

    @Step("Login with email={email}")
    public void login(String email, String password) {
        type(loginEmail, email);
        type(loginPassword, password);
        click(loginBtn);
    }

    @Step("Verify login error is shown")
    public SignupLoginPage verifyLoginError() {
        shouldBeVisible(loginError);
        return this;
    }
}
