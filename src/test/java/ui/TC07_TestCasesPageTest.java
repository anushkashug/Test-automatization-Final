package com.Ana.tests.ui;

import com.Ana.framework.core.BaseTest;
import com.Ana.framework.ui.pages.HomePage;
import org.testng.annotations.Test;

public class TC07_TestCasesPageTest extends BaseTest {

    @Test
    public void verifyTestCasesPage() {
        new HomePage().open()
                .goToTestCases()
                .verifyOpened();
    }
}
