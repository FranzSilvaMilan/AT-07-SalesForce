package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(xpath = "//select[contains(@id,'Family')]")
    private WebElement productFamilyCombobox;

    @FindBy(xpath = "//textarea[@type='text']")
    private WebElement productDescriptionTextArea;

    @FindBy(xpath = "//td[@id='topButtonRow']//input[contains(@title,'Save')]")
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
        if(product.getProductName() != null)driverTools.setInputField(productNameInput, product.getProductName());
        if(product.getProductCode() != null)driverTools.setInputField(productCodeInput, product.getProductCode());
        if(product.getProductDescription() != null)driverTools.setInputField(productDescriptionTextArea, product.getProductDescription());
        if(product.getProductFamily() != null) {
            driverTools.selectChkBox(actionOptionCheckBox);
            Select select = new Select(productFamilyCombobox);
            select.selectByVisibleText(product.getProductFamily());
        }
        driverTools.clickElement(saveButton);
        return new ProductDetailsPageClassic();
    }

    /**
     * Methof for edit a Product in the form page Classic.
     * @param product form's fields.
     * @return product's detail edited.
     */
    @Override
    public ProductDetailsPage clickSaveEditProduct(Product product) {
        driverTools.setInputField(productNameInput, product.getProductName());
        driverTools.setInputField(productCodeInput, product.getProductCode());
        driverTools.setInputField(productDescriptionTextArea, product.getProductDescription());
        driverTools.selectChkBox(actionOptionCheckBox);
        Select select = new Select(productFamilyCombobox);
        select.selectByVisibleText(product.getProductFamily());
        driverTools.clickElement(saveButton);
        return new ProductDetailsPageClassic();
    }
}
