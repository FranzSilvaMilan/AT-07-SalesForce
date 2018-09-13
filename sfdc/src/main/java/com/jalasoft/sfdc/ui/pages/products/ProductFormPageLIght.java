package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.entities.Product;
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

    @FindBy(xpath = "(//div[@class ='uiInput uiInputText uiInput--default uiInput--input']/child::input)[2]")
    private WebElement productCodeInput;

    @FindBy(css = ".uiInput--checkbox input")
    private WebElement actionOptionCheckBox;

    @FindBy(xpath = "//a[@class='select']")
    private WebElement productFamilyCombobox;

    @FindBy(xpath = "//textarea[@role='textbox']")
    private WebElement productDescriptionTextArea;

    @FindBy(xpath = "//span[@class='genericError uiOutputText']")
    private WebElement messageError;

    @FindBy(xpath = "//button[@title='Save']")
    private WebElement saveButton;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for fill and create new product in the form page Light.
     * @param product form's fields.
     * @return product's detail created.
     */
    @Override
    public ProductDetails clickSaveProduct(Product product) {
        driverTools.setInputField(productNameInput, product.getProductName());
        driverTools.setInputField(productCodeInput, product.getProductCode());
        driverTools.setInputField(productDescriptionTextArea, product.getProductDescription());
        if(true) {
            driverTools.clickElement(actionOptionCheckBox);
        }
        driverTools.clickElement(saveButton);
        return new ProductDetailsLight();
    }
}
