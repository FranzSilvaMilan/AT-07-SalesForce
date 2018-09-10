package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductFormPageClassic extends ProductFormPage {

    /**
     * Elements form page Classic create new product.
     */
    @FindBy(xpath = "//input[contains(@id,'Name')]")
    WebElement productName;

    /**
     * Elements Buttons form page Classic.
     */
    @FindBy(xpath = "//input[contains(@tabindex,'6')]")
    WebElement saveButton;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for fill and create new product in the form page Classic.
     * @param name form's fields.
     * @return product's details created.
     */
    @Override
    public ProductDetails ClickSaveProduct(String name) {
        driverTools.setInputField(productName, name);
        driverTools.clickElement(saveButton);
        return new ProductDetailsClassic();
    }
}
