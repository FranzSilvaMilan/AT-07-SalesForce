package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Product Details Page Light class.
 *
 * @author Erik Vargas
 */
public class ProductDetailsPageLight extends ProductDetailsPage {

    @FindBy(xpath = "(//span[@class='uiOutputText'])[2]")
    private WebElement productNameLabel;

    @FindBy(xpath = "(//span[@class='uiOutputText'])[4]")
    private WebElement productNameInput;

    @FindBy(xpath = "(//span[contains(@class,'separator is-read-only')])[3]")
    private WebElement productCodeInput;

    @FindBy(xpath = "//span[@class='uiOutputTextArea']")
    private WebElement productDescripionTextArea;

    @FindBy(xpath = "//img[@alt='True']")
    private WebElement productActiveCheckbox;

    @FindBy(xpath = "(//span[contains(@class,'separator is-read-only')])[4]")
    private WebElement productFamilyComboBox;

    @FindBy(css = ".sldsButtonHeightFix")
    private WebElement dropdownEditButton;

    @FindBy(css = "a[title = 'Edit']")
    private WebElement editButton;

    @FindBy(xpath = "\"//a[@title='Delete']")
    private WebElement deletButton;

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

    /**
     * Method for validated that Product was created with all fields.
     * @return list of form's fields.
     */
    @Override
    public List<String> validateInputs() {
        ArrayList<String> listInputs = new ArrayList<>();
        listInputs.add(productNameInput.getText());
        listInputs.add(productCodeInput.getText());
        listInputs.add(productDescripionTextArea.getText());
        listInputs.add(productFamilyComboBox.getText());
        return listInputs;
    }

    /**
     * Method for validated checkbox.
     * @return value boolean.
     */
    @Override
    public boolean validateCheckBox() {
        return productActiveCheckbox.isSelected();
    }

    /**
     * Method for edit Product.
     * @return Product form page light.
     */
    @Override
    public ProductFormPage clickEditBtn() {
        driverTools.clickElement(dropdownEditButton);
        driverTools.waitUntilElementDisplayed(editButton);
        driverTools.clickElement(editButton);
        return new ProductFormPageLIght();
    }

    /**
     * Method for delete Product.
     */
    @Override
    public void clickDeletButton() {
        driverTools.clickElement(dropdownEditButton);
        driverTools.clickElement(deletButton);
        acceptAlertDialog();
    }
}
