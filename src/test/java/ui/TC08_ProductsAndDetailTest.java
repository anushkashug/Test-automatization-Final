package com.Ana.tests.ui;

import com.Ana.framework.core.BaseTest;
import com.Ana.framework.ui.pages.HomePage;
import org.testng.annotations.Test;

public class TC08_ProductsAndDetailTest extends BaseTest {

    @Test
    public void productsAndDetail() {
        new HomePage().open()
                .goToProducts()
                .verifyOpened()
                .openFirstProduct()
                .verifyDetailsVisible();
    }
}
