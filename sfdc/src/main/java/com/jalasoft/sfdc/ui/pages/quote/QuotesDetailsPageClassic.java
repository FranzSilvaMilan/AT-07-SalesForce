package com.jalasoft.sfdc.ui.pages.quote;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuotesDetailsPageClassic extends QuotesDetailsPage {
    @FindBy(xpath = "//input[@title='Add Line Item']")
    WebElement addLineItemButton;
    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public QuotesAddProductPage addProduct(){
        driverTools.clickElement(addLineItemButton);
        return new QuotesAddProductPageClassic();
    }
}
