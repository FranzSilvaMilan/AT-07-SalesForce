package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.entities.Product;
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

    @FindBy(xpath = "//p[contains(text(),'Product')]/following::h1")
    private WebElement productNameLabel;

    @FindBy(xpath = "//span[contains(text(),'Product Name')]/parent::div/following-sibling::div/span/span")
    private WebElement productNameInput;

    @FindBy(xpath = "//span[contains(text(),'Product Code')]//parent::div//following-sibling::div//span//span")
    private WebElement productCodeInput;

    @FindBy(xpath = "//span[@class='uiOutputTextArea']")
    private WebElement productDescripionTextArea;

    @FindBy(xpath = "//span[contains(text(),'Active')]//parent::div//following-sibling::div//span//span")
    private WebElement productActiveCheckbox;

    @FindBy(xpath = "//span[contains(text(),'Product Family')]//parent::div//following-sibling::div//span")
    private WebElement productFamilyComboBox;

    @FindBy(css = ".sldsButtonHeightFix")
    private WebElement dropdownButton;

    @FindBy(css = "a[title = 'Edit']")
    private WebElement editButton;

    @FindBy(xpath = "//a[@title='Delete']")
    private WebElement deletButton;

    @FindBy(xpath = "//span[(text()='Delete')]")
    private WebElement popupDeleteButton;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        driverTools.waitUntilElementDisplayed(productNameLabel);
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
        driverTools.moveAndClickElement(dropdownButton);
        driverTools.clickElement(editButton);
        return new ProductFormPageLIght();
    }

    @Override
    public boolean validateDelete(Product product) {
        return false;
    }

    /**
     * Method for delete Product.
     */
    @Override
    public void clickDeleteButton() {
        driverTools.moveAndClickElement(dropdownButton);
        driverTools.clickElement(deletButton);
        driverTools.clickElement(popupDeleteButton);
    }

    @Override
    public ProductDetailsPage clickAddPriceStandard(String priceStandard) {
        return null;
    }

    @Override
    public ProductDetailsPage clickAddPriceBook(String priceBook) {
        return null;
    }

    @Override
    public void getIdProduct(Product product) {
        String url = driver.getCurrentUrl();
        String[] urlSplit = url.split("/");
        product.setId(urlSplit[urlSplit.length - 2]);
    }
}
