package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsClassic extends ProductDetails {

    @FindBy(xpath = "//h2[contains(@class,'pageDescription')]")
    private WebElement ProductName;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public String isProductNameDisplayed() {
        return ProductName.getText();
    }
}
