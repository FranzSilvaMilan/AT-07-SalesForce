package com.jalasoft.sfdc.ui.pages.quote;

import com.jalasoft.sfdc.entities.Quote;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuotesFormPageClassic extends QuotesFormPage {
    @FindBy(xpath = "//input[@name='Name']")
    WebElement setQuoteNameInput;
    @FindBy(xpath = "//input[@tabindex='23']")
    WebElement saveQuoteButton;
    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public QuotesDetailsPage gotToSaveButton(String quotes) {
        driverTools.setInputField(setQuoteNameInput, quotes);
        driverTools.clickElement(saveQuoteButton);
        return new QuotesDetailsPageClassic();
    }
}
