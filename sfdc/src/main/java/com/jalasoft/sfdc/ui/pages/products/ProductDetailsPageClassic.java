package com.jalasoft.sfdc.ui.pages.products;

import java.util.ArrayList;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Product Details Page Classic class.
 *
 * @author Erik Vargas
 */
public class ProductDetailsPageClassic extends ProductDetailsPage {

    @FindBy(xpath = "//h2[contains(@class,'pageDescription')]")
    private WebElement productNameLabel;

    @FindBy(xpath = "//div[@id='Name_ileinner']")
    private WebElement productNameInput;

    @FindBy(xpath = "//div[@id='ProductCode_ileinner']")
    private WebElement productCodeInput;

    @FindBy(xpath = "//div[contains(@id,'Description_ileinner')]")
    private WebElement productDescripionTextArea;

    @FindBy(xpath = "//div[@id='IsActive_ileinner']//child::img")
    private WebElement productActiveCheckbox;

    @FindBy(xpath = "//div[@id='Family_ileinner']")
    private WebElement productFamilyComboBox;

    @FindBy(xpath = "//td[@id='topButtonRow']//input[@title='Edit']")
    private WebElement editButton;

    @FindBy(xpath = "//td[@id='topButtonRow']//input[@title='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//input[contains(@title,'Add')]")
    private WebElement addStandardPriceButton;

    @FindBy(xpath = "//input[@title='Unit Price']")
    private WebElement priseStandardInput;

    @FindBy(xpath = "//input[@title='Save']")
    private WebElement saveStandardPriceButton;

    @FindBy(xpath = "//input[@title='Add to Price Book']")
    private WebElement addPriceBookButton;

    @FindBy(xpath = "//input[contains(@title,'Select Standard')]")
    private WebElement standartCheckBox;

    @FindBy(xpath = "(//input[@title='Select'])[1]")
    private WebElement selectPriceBookButton;

    @FindBy(xpath = "//input[@title='List Price 1']")
    private WebElement listPriceInput;

    @FindBy(xpath = "//input[@title='Save']")
    private WebElement savePriceBookButton;

    private static final String PRODUCT_NAME_LBL = "//img[contains(@title,'%s')]";


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
     * @return Product form page Classic.
     */
    @Override
    public ProductFormPage clickEditBtn() {
        driverTools.clickElement(editButton);
        return new ProductFormPageClassic();
    }

    /**
     * Method for delete Product.
     */
    @Override
    public void clickDeleteButton() {
        driverTools.clickElement(deleteButton);
        acceptAlertDialog();
    }

    /**
     * Method that validate a product deleted.
     * @param product fields products.
     * @return false.
     */
    @Override
    public boolean validateDelete(Product product) {
        //return driverTools.isElementDisplayed(By.xpath("//img[contains(@title,'"+product.getProductName()+"')]"));
        return driverTools.isElementDisplayed(By.xpath(String.format(PRODUCT_NAME_LBL, product.getProductName())));
    }

    /**
     * Method for add a price standard to Product.
     * @param priceStandard field.
     * @return product details page.
     */
    @Override
    public ProductDetailsPage clickAddPriceStandard(String priceStandard) {
        driverTools.clickElement(addStandardPriceButton);
        driverTools.setInputField(priseStandardInput,priceStandard);
        driverTools.clickElement(saveStandardPriceButton);
        return new ProductDetailsPageClassic();
    }

    /**
     * Method for add a price book to Product.
     * @param priceBook field.
     * @return product details page.
     */
    @Override
    public ProductDetailsPage clickAddPriceBook(String priceBook) {
        driverTools.clickElement(addPriceBookButton);
        driverTools.selectChkBox(standartCheckBox);
        driverTools.clickElement(selectPriceBookButton);
        driverTools.setInputField(listPriceInput,priceBook);
        driverTools.clickElement(savePriceBookButton);
        return new ProductDetailsPageClassic();
    }

    @Override
    public void getIdProduct(Product product) {
        String url = driver.getCurrentUrl();
        String[] urlSplit = url.split("/");
        product.setId(urlSplit[urlSplit.length - 1]);
    }
}
