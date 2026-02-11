package com.Ana.framework.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ContactUsPage extends BasePage {

    private final By getInTouch = By.xpath("//*[contains(text(),'GET IN TOUCH') or contains(text(),'Get In Touch')]");
    private final By name = By.name("name");
    private final By email = By.name("email");
    private final By subject = By.name("subject");
    private final By message = By.id("message");
    private final By upload = By.name("upload_file");
    private final By submit = By.name("submit");
    private final By success = By.xpath("//*[contains(text(),'Success! Your details have been submitted successfully.')]");

    private final By homeBtn = By.cssSelector("a.btn.btn-success");

    @Step("Verify Contact Us page opened")
    public ContactUsPage verifyOpened() {
        shouldBeVisible(getInTouch);
        return this;
    }

    @Step("Submit Contact Us form")
    public ContactUsPage submitForm(String n, String e, String s, String m, String filePath) {
        type(name, n);
        type(email, e);
        type(subject, s);
        type(message, m);
        if (filePath != null) {
            driver.findElement(upload).sendKeys(filePath);
        }
        click(submit);
        acceptAlertIfPresent();
        shouldBeVisible(success);
        return this;
    }

    @Step("Go Home from Contact Us page")
    public HomePage goHome() {
        click(homeBtn);
        return new HomePage();
    }
}
