package com.jalasoft.sfdc.ui.pages.quote;

import com.jalasoft.sfdc.entities.Quote;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuoteItemPageClassic extends QuoteItemPage {
    @FindBy(xpath = "//input[contains(@name,'Quantity01u0b00002IXVjO')]")
    WebElement quantityInput;
    @FindBy(xpath = "(//input[@title='Save'])[1]")//ToDo
    WebElement saveQuoteButton;
    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
     public QuotesDetailsPage isClickSaveItemButton(Quote quote){
        driverTools.setInputField(quantityInput,quote.getQuantity());//ToDo
        driverTools.clickElement(saveQuoteButton);
        return new QuotesDetailsPageClassic();
     }
}
