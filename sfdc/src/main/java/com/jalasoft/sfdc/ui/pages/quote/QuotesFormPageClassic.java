package com.jalasoft.sfdc.ui.pages.quote;

import com.jalasoft.sfdc.entities.Quote;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuotesFormPageClassic extends QuotesFormPage {
    @FindBy(xpath = "//input[@name='Name']")
    private WebElement setQuoteNameInput;
    @FindBy(xpath = "//input[@tabindex='23']")
    private WebElement saveQuoteButton;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * The abstract method that set and save new Quotes.
     * @param quote - class object Quotes.
     * @return new Details page Classic.
     */
    @Override
    public QuotesDetailsPage gotToSaveButton(Quote quote) {
        driverTools.setInputField(setQuoteNameInput, quote.getQuoteName());
        driverTools.clickElement(saveQuoteButton);
        return new QuotesDetailsPageClassic();
    }
}
