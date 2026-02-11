package com.Ana.tests.ui;

import com.Ana.framework.core.BaseTest;
import com.Ana.framework.ui.pages.HomePage;
import org.testng.annotations.Test;

public class TC09_SearchProductTest extends BaseTest {

    @Test
    public void searchProduct() {
        new HomePage().open()
                .goToProducts()
                .verifyOpened()
                .search("top")
                .verifySearchResultsVisible();
    }
}
