package com.jalasoft.sfdc.ui.pages.products;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductListPageLight extends ProductListPage {

    /**
     * Element product home page light.
     */
    @FindBy(xpath = "//a[@class='forceActionLink' and @role='button' and @title='New']")
    private WebElement buttonNew;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf( buttonNew));
    }

    /**
     * Method for implement click on button new in the product home page Light.
     * @return form crete new product.
     */
    @Override
    public ProductFormPage clickButtonNew() {
        driverTools.clickElement(buttonNew);
        return new ProductFormPageLIght();
    }

}
