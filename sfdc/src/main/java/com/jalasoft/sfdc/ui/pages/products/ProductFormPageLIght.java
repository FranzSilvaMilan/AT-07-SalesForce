package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Product Form Page Light class.
 *
 * @author Erik Vargas
 */
public class ProductFormPageLIght extends ProductFormPage {

    @FindBy(xpath = "//*[@aria-required='true']")
    private WebElement productNameInput;

    @FindBy(xpath = "")
    private WebElement productCodeInput;

    @FindBy(xpath = "")
    private WebElement actionOptionCheckBox;

    @FindBy(xpath = "")
    private WebElement productFamilyCombobox;

    @FindBy(xpath = "")
    private WebElement productDescriptionTextArea;

    @FindBy(xpath = "//span[@class='genericError uiOutputText']")
    private WebElement messageError;

    @FindBy(xpath = "//button[@title='Save']")
    private WebElement saveButton;

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
     * @return product's detail created.
     */
    @Override
    public ProductDetails clickSaveProduct(String name) {
        driverTools.setInputField(productNameInput, name);
        driverTools.clickElement(saveButton);
        return new ProductDetailsLight();
    }
}
