package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductFormPageLIght extends ProductFormPage {

    /**
     * Elements form page Light create new product.
     */
    @FindBy(xpath = "//*[@aria-required='true']")
    private WebElement productName;

    @FindBy(xpath = "")
    private WebElement productCode;

    @FindBy(xpath = "")
    private WebElement checkOptionActive;

    @FindBy(xpath = "")
    private WebElement productFamily;

    @FindBy(xpath = "")
    private WebElement productDescription;

    @FindBy(xpath = "//span[@class='genericError uiOutputText']")
    private WebElement message;

    /**
     * Elements Buttons form page Light.
     */
    @FindBy(xpath = "//button[@title='Save']")
    WebElement saveButton;

    @FindBy(xpath = "")
    private WebElement saveNewButton;

    @FindBy(xpath = "")
    private WebElement cancelButton;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for fill and create new product in the form page Light.
     * @param name form's fields.
     * @return product's details created.
     */
    @Override
    public ProductDetails clickSaveProduct(String name) {
        driverTools.setInputField(productName, name);
        driverTools.clickElement(saveButton);
        return new ProductDetailsLight();
    }
}
