package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Product Details Page Classic class.
 *
 * @author Erik Vargas
 */
public class ProductDetailsPageClassic extends ProductDetailsPage {

    @FindBy(xpath = "//h2[contains(@class,'pageDescription')]")
    private WebElement productNameLabel;

    @FindBy(xpath = "(//input[@title='Edit'])[1]")
    WebElement editButton;

    @FindBy(xpath = "//input[@name='Name']")
    WebElement productNameInput;

    @FindBy(xpath = "//input[@name='ProductCode']")
    WebElement productCodeInput;


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

    @Override
    public ProductFormPage clickEditBtn1() {
        driverTools.clickElement(editButton);
        return new ProductFormPageClassic();
    }

    @Override
    public List<String> validateInputs1() {
        ArrayList<String> listInputs = new ArrayList<>();
        listInputs.add(productNameInput.getText());
        listInputs.add(productCodeInput.getText());
        return listInputs;
    }
}
