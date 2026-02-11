package com.Ana.tests.ui;

import com.Ana.framework.core.BaseTest;
import com.Ana.framework.ui.components.HeaderComponent;
import com.Ana.framework.ui.pages.AccountCreatedPage;
import com.Ana.framework.ui.pages.HomePage;
import com.Ana.framework.utils.TestData;
import org.testng.annotations.Test;

public class TC01_RegisterUserTest extends BaseTest {

    @Test
    public void registerUser() {
        String email = TestData.uniqueEmail();
        String password = "Pass123!";

        HomePage home = new HomePage().open();
        home.goToSignupLogin()
                .startSignup("Test User", email)
                .createAccount(password);

        new AccountCreatedPage().continueToHome();

        new HeaderComponent()
                .verifyLoggedIn()
                .deleteAccount(); // keep site clean
    }
}
