package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.entities.Product;
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

    @FindBy(xpath = "//input[@id='ProductCode']")
    private WebElement productCodeInput;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement actionOptionCheckBox;

    @FindBy(xpath = "//select[@name='Family']")
    private WebElement productFamilyCombobox;

    @FindBy(xpath = "//textarea[@type='text']")
    private WebElement productDescriptionTextArea;

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
     * @param product form's fields.
     * @return product's detail created.
     */
    @Override

    public ProductDetailsPage clickSaveProduct(Product product) {
        driverTools.setInputField(productNameInput, product.getProductName());
        driverTools.setInputField(productCodeInput, product.getProductCode());
        driverTools.setInputField(productDescriptionTextArea, product.getProductDescription());
        if(true) {
            driverTools.clickElement(actionOptionCheckBox);
        }
        driverTools.clickElement(saveButton);
        return new ProductDetailsPageClassic();
    }
}
