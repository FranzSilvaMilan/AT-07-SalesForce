package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListPageClassic extends ProductListPage {

    /**
     * Element product home page classic.
     */
    @FindBy(xpath = "//input[@value=' New ']")
    private WebElement buttonNew;

    @FindBy(css = "#tryLexDialogX")
    private WebElement buttonClosePopup;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for implement click on button new in the product home page Classic.
     * @return form crete new product.
     */
    @Override
    public ProductFormPage clickButtonNew() {
        driverTools.clickElement(buttonClosePopup);
        driverTools.clickElement(newAccountButton);
        return new ProductFormPageClassic();
    }
}
