package com.Ana.framework.ui.pages.;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage {

    private final By allProductsHeader = By.xpath("//*[contains(text(),'All Products')]");
    private final By firstViewProduct = By.cssSelector("a[href^='/product_details/']");

    private final By searchInput = By.id("search_product");
    private final By searchBtn = By.id("submit_search");
    private final By searchedProductsHeader = By.xpath("//*[contains(text(),'SEARCHED PRODUCTS')]");
    private final By searchedResultsAny = By.cssSelector(".product-image-wrapper");

    @Step("Verify Products page opened")
    public ProductsPage verifyOpened() {
        shouldBeVisible(allProductsHeader);
        return this;
    }

    @Step("Open first product details")
    public ProductDetailsPage openFirstProduct() {
        click(firstViewProduct);
        return new ProductDetailsPage();
    }

    @Step("Search product: {keyword}")
    public ProductsPage search(String keyword) {
        type(searchInput, keyword);
        click(searchBtn);
        return this;
    }

    @Step("Verify searched products section and results are visible")
    public ProductsPage verifySearchResultsVisible() {
        shouldBeVisible(searchedProductsHeader);
        shouldBeVisible(searchedResultsAny);
        return this;
    }
}
