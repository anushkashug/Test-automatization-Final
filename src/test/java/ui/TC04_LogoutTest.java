package com.Ana.tests.ui;

import com.Ana.framework.core.BaseTest;
import com.Ana.framework.ui.components.HeaderComponent;
import com.Ana.framework.ui.pages.AccountCreatedPage;
import com.Ana.framework.ui.pages.HomePage;
import com.Ana.framework.utils.TestData;
import org.testng.annotations.Test;

public class TC04_LogoutTest extends BaseTest {

    @Test
    public void logoutUser() {
        String email = TestData.uniqueEmail();
        String password = "Pass123!";

        new HomePage().open()
                .goToSignupLogin()
                .startSignup("Test User", email)
                .createAccount(password);

        new AccountCreatedPage().continueToHome();

        HeaderComponent header = new HeaderComponent().verifyLoggedIn();
        header.logout();

        // just verify we can see login page again by opening it
        new HomePage().open().goToSignupLogin();
    }
}
