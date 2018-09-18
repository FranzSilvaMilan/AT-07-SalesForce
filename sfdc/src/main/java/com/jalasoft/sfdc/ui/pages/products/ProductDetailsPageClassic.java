package com.jalasoft.sfdc.ui.pages.products;

import java.util.ArrayList;
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

    @FindBy(xpath = "//img[@alt='Checked']")
    private WebElement productActiveCheckbox;

    @FindBy(xpath = "//div[@id='Family_ileinner']")
    private WebElement productFamilyComboBox;

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
}
