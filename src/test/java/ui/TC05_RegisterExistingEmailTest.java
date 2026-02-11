package com.Ana.tests.ui;

import com.Ana.framework.core.BaseTest;
import com.Ana.framework.ui.components.HeaderComponent;
import com.Ana.framework.ui.pages.AccountCreatedPage;
import com.Ana.framework.ui.pages.HomePage;
import com.Ana.framework.ui.pages.SignupLoginPage;
import com.Ana.framework.utils.TestData;
import org.testng.annotations.Test;

public class TC05_RegisterExistingEmailTest extends BaseTest {

    @Test
    public void registerExistingEmail() {
        String email = TestData.uniqueEmail();
        String password = "Pass123!";

        // First register
        new HomePage().open()
                .goToSignupLogin()
                .startSignup("Test User", email)
                .createAccount(password);

        new AccountCreatedPage().continueToHome();
        new HeaderComponent().verifyLoggedIn().logout();

        // Second signup attempt with same email => error
        SignupLoginPage page = new HomePage().open().goToSignupLogin();
        page.signupExpectExistingEmailError("Test User", email);
    }
}
