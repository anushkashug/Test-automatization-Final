package com.Ana.framework.ui.components;

import com.Ana.framework.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HeaderComponent extends BasePage {

    private final By logoutLink = By.cssSelector("a[href='/logout']");
    private final By deleteAccountLink = By.cssSelector("a[href='/delete_account']");
    private final By loggedInAs = By.xpath("//*[contains(text(),'Logged in as')]");

    @Step("Verify user is logged in")
    public HeaderComponent verifyLoggedIn() {
        shouldBeVisible(loggedInAs);
        return this;
    }

    private void shouldBeVisible(By loggedInAs) {
        
    }

    @Step("Logout")
    public void logout() {
        click(logoutLink);
    }

    private void click(By logoutLink) {
    }

    @Step("Delete account")
    public void deleteAccount() {

    }
}
