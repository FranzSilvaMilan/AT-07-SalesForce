package com.jalasoft.sfdc.ui.pages.quote;

import com.jalasoft.sfdc.entities.Quote;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuoteItemPageClassic extends QuoteItemPage {
    @FindBy(xpath = "//input[contains(@name,'Quantity')]")
    private WebElement quantityInput;
    @FindBy(xpath = "//input[contains(@id='UnitPrice'")
    private WebElement unitPrice;
    @FindBy(xpath = "(//input[@title='Save'])[1]")
    private WebElement saveQuoteButton;
    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
     public QuotesDetailsPage isClickSaveItemButton(Quote quote){
        //driverTools.setInputField(unitPrice,quote.getPrice());
        driverTools.setInputField(quantityInput,quote.getQuantity());
        driverTools.clickElement(saveQuoteButton);
        return new QuotesDetailsPageClassic();
     }
}
