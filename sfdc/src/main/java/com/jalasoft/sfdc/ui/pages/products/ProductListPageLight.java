package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

/**
 * Product List Page Light class.
 *
 * @author Erik Vargas
 */
public class ProductListPageLight extends ProductListPage {

    // Elements for edit products

    @FindBy(xpath = "(//a[@tabindex='0'])[40]")
    public WebElement editButton1;

    @FindBy(xpath = "//a[contains(.,'Edit')]")
    WebElement editItem;

    @FindBy(xpath = "//a[@data-recordid='01t0b00000Fk7rqAAB']")
    WebElement productNameInput;

    @FindBy(xpath = "(//span[@class='slds-truncate uiOutputText'])[1]")
    WebElement productCodeInput;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
    }

    /**
     * Method for implement button new in the product home page Light.
     * @return form create new product.
     */
    @Override
    public ProductFormPage clickButtonNew() {
        driverTools.clickElement(newButton);
        return new ProductFormPageLIght();
    }

    @Override
    public ProductFormPage clickEditBtn() {
        System.out.println("entraaaaaaaaa");
        driverTools.clickElement(editButton1);
        driverTools.clickElement(editItem);
        return new ProductFormPageLIght();
    }

    @Override
    public List<String> validateInputs() {
        ArrayList<String> listInputs = new ArrayList<>();
        listInputs.add(productNameInput.getText());
        listInputs.add(productCodeInput.getText());
        return listInputs;
    }
}
