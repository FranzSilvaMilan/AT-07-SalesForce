package com.jalasoft.sfdc.ui.pages.quote;

import com.jalasoft.sfdc.entities.Quote;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuotesDetailsPageClassic extends QuotesDetailsPage {
    @FindBy(xpath = "//input[@title='Add Line Item']")
    private WebElement addLineItemButton;

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

    @Override
    public void getIdQuote(Quote quote) {
        String url = driver.getCurrentUrl();
        String[] urlSplit = url.split("/");
        quote.setId(urlSplit[urlSplit.length - 1]);
    }
}
