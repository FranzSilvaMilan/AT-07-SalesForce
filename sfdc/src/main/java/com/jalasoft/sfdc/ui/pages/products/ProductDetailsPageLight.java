package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Product Details Page Light class.
 *
 * @author Erik Vargas
 */
public class ProductDetailsPageLight extends ProductDetailsPage {

    @FindBy(xpath = "(//span[@class='uiOutputText'])[2]")
    private WebElement productNameLabel;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for validated that Product was created in the Product detail Page Light.
     * @return Product name created.
     */
    @Override
    public String isProductNameDisplayed() {
        return productNameLabel.getText();
    }
}
