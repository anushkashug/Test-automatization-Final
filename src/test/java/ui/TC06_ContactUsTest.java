package com.Ana.tests.ui;

import com.Ana.framework.core.BaseTest;
import com.Ana.framework.ui.pages.ContactUsPage;
import com.Ana.framework.ui.pages.HomePage;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;

public class TC06_ContactUsTest extends BaseTest {

    @Test
    public void contactUsForm() throws Exception {
        // open Contact Us directly (stable)
        new HomePage().open();
        com.Ana.framework.core.DriverFactory.getDriver().get("https://automationexercise.com/contact_us");

        // temp file for upload
        Path tmp = Files.createTempFile("contact", ".txt");
        Files.writeString(tmp, "Hello from Selenium!");

        new ContactUsPage()
                .verifyOpened()
                .submitForm("Test User", "test@example.com", "Subject", "My message", tmp.toAbsolutePath().toString())
                .goHome();
    }
}
