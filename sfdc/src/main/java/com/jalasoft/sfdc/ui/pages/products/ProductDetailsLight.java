package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsLight extends ProductDetails {

    /**
     * Element Product name of the product detail page.
     */
    @FindBy(xpath = "(//span[@class='uiOutputText'])[2]")
    private WebElement ProductName;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for validated that Product was created in the Product detail Page Light.
     * @return Product name created.
     */
    @Override
    public String isProductNameDisplayed() {
        return ProductName.getText();
    }
}
