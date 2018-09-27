package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//span[contains(text(),'Product Code')]//parent::label//following-sibling::input")
    private WebElement productCodeInput;

    @FindBy(css = ".uiInput--checkbox input")
    private WebElement actionOptionCheckBox;

    @FindBy(xpath = "//a[@class='select']")
    private WebElement productFamilyCombobox;

    @FindBy(xpath = "//textarea[@role='textbox']")
    private WebElement productDescriptionTextArea;

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
    public ProductDetailsPage clickSaveProduct(Product product) {
        driverTools.setInputField(productNameInput, product.getProductName());
        driverTools.setInputField(productCodeInput, product.getProductCode());
        driverTools.setInputField(productDescriptionTextArea, product.getProductDescription());
        driverTools.selectChkBox(actionOptionCheckBox);
        driverTools.clickElement(productFamilyCombobox);
        driverTools.clickElement(By.xpath("//a[contains(@title,'"+product.getProductFamily()+"')]//following::a"));
        driverTools.clickElement(saveButton);
        return new ProductDetailsPageLight();
    }

    /**
     * Methof for edit a Product in the form page light.
     * @param product form's fields.
     * @return product's detail edited.
     */
    @Override
    public ProductDetailsPage clickSaveEditProduct(Product product) {
        driverTools.clearTextField(productNameInput);
        driverTools.clearTextField(productCodeInput);
        driverTools.clearTextField(productDescriptionTextArea);
        driverTools.setInputField(productNameInput, product.getProductName());
        driverTools.setInputField(productCodeInput, product.getProductCode());
        driverTools.setInputField(productDescriptionTextArea, product.getProductDescription());
        driverTools.clearChkBox(actionOptionCheckBox);
        driverTools.clickElement(productFamilyCombobox);
        driverTools.clickElement(By.xpath("//a[contains(@title,'"+product.getProductFamily()+"')]//following::a"));
        driverTools.clickElement(saveButton);
        driverTools.waitWebElementInVisibility(saveButton);
        return new ProductDetailsPageLight();
    }
}
