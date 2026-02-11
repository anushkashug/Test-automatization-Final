package com.Ana.tests.ui;

import com.Ana.framework.core.BaseTest;
import com.Ana.framework.ui.pages.HomePage;
import com.Ana.framework.ui.pages.SignupLoginPage;
import org.testng.annotations.Test;

public class TC03_LoginIncorrectTest extends BaseTest {

    @Test
    public void loginIncorrect() {
        SignupLoginPage login = new HomePage().open().goToSignupLogin();
        login.login("wrong_" + System.currentTimeMillis() + "@example.com", "WrongPass!");
        login.verifyLoginError();
    }
}
