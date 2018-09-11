package com.jalasoft.sfdc.ui.pages.products;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Product List Page Light class.
 *
 * @author Erik Vargas
 */
public class ProductListPageLight extends ProductListPage {

    @FindBy(xpath = "//a[@class='forceActionLink' and @role='button' and @title='New']")
    private WebElement newProductButton;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newProductButton));
    }

    /**
     * Method for implement button new in the product home page Light.
     * @return form create new product.
     */
    @Override
    public ProductFormPage clickButtonNew() {
        driverTools.clickElement(newAccountButton);
        return new ProductFormPageLIght();
    }
}
