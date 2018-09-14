package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Product Details Page Light class.
 *
 * @author Erik Vargas
 */
public class ProductDetailsPageLight extends ProductDetailsPage {

    @FindBy(xpath = "(//span[@class='uiOutputText'])[2]")
    private WebElement productNameLabel;

    /**
     * Waits until page object is loaded.
     */
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

    @Override
    public ProductFormPage clickEditBtn1() {
        return null;
    }

    @Override
    public List<String> validateInputs1() {
        return null;
    }
}
