package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductFormPageLIght extends ProductFormPage {

    /**
     * Elements form page Light create new product.
     */
    @FindBy(xpath = "//*[@aria-required='true']")
    WebElement productName;

    @FindBy(xpath = "")
    WebElement productCode;

    @FindBy(xpath = "")
    WebElement checkOptionActive;

    @FindBy(xpath = "")
    WebElement productFamily;

    @FindBy(xpath = "")
    WebElement productDescription;

    @FindBy(xpath = "//span[@class='genericError uiOutputText']")
    WebElement message;

    /**
     * Elements Buttons form page Light.
     */
    @FindBy(xpath = "//button[@title='Save']")
    WebElement saveButton;

    @FindBy(xpath = "")
    WebElement saveNewButton;

    @FindBy(xpath = "")
    WebElement cancelButton;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for fill and create new product in the form page Light.
     * @param name form's fields.
     * @return product's details created.
     */
    @Override
    public ProductDetails ClickSaveProduct(String name) {
        driverTools.setInputField(productName, name);
        driverTools.clickElement(saveButton);
        return new ProductDetailsLight();
    }

}
