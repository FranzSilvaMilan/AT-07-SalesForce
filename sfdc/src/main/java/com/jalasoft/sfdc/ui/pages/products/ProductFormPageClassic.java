package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Product Form Page Classic class.
 *
 * @author Erik Vargas
 */
public class ProductFormPageClassic extends ProductFormPage {

    @FindBy(xpath = "//input[contains(@id,'Name')]")
    private WebElement productNameInput;

    @FindBy(xpath = "//input[contains(@tabindex,'6')]")
    private WebElement saveButton;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for fill and create new product in the form page Classic.
     * @param name form's fields.
     * @return product's detail created.
     */
    @Override
    public ProductDetails clickSaveProduct(String name) {
        driverTools.setInputField(productNameInput, name);
        driverTools.clickElement(saveButton);
        return new ProductDetailsClassic();
    }
}
