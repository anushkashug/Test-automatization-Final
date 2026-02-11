package com.Ana.tests.ui;

import com.Ana.framework.core.BaseTest;
import com.Ana.framework.ui.pages.HomePage;
import com.Ana.framework.utils.TestData;
import org.testng.annotations.Test;

public class TC10_SubscriptionHomeTest extends BaseTest {

    @Test
    public void subscriptionHome() {
        new HomePage().open()
                .subscribe(TestData.uniqueEmail());
    }
}
