package com.Ana.tests.ui;

import com.Ana.framework.core.BaseTest;
import com.Ana.framework.ui.components.HeaderComponent;
import com.Ana.framework.ui.pages.AccountCreatedPage;
import com.Ana.framework.ui.pages.HomePage;
import com.Ana.framework.utils.TestData;
import org.testng.annotations.Test;

public class TC02_LoginCorrectTest extends BaseTest {

    @Test
    public void loginCorrect() {
        String email = TestData.uniqueEmail();
        String password = "Pass123!";

        // Register
        new HomePage().open()
                .goToSignupLogin()
                .startSignup("Test User", email)
                .createAccount(password);

        new AccountCreatedPage().continueToHome();

        // Logout
        new HeaderComponent().logout();

        // Login
        new HomePage().open()
                .goToSignupLogin()
                .login(email, password);

        new HeaderComponent()
                .verifyLoggedIn()
                .deleteAccount();
    }
}
