package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Product Details Page Classic class.
 *
 * @author Erik Vargas
 */
public class ProductDetailsClassic extends ProductDetails {

    @FindBy(xpath = "//h2[contains(@class,'pageDescription')]")
    private WebElement productNameLabel;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for validated that Product was created in the Product detail Page Classic.
     * @return Product name created.
     */
    @Override
    public String isProductNameDisplayed() {
        return productNameLabel.getText();
    }
}
