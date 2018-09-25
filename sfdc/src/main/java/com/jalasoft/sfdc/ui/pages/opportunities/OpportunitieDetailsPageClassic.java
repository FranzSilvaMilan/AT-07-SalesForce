package com.jalasoft.sfdc.ui.pages.opportunities;

import com.jalasoft.sfdc.entities.Opportunitie;
import com.jalasoft.sfdc.ui.pages.quote.QuotesFormPage;
import com.jalasoft.sfdc.ui.pages.quote.QuotesFormPageClassic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunitieDetailsPageClassic extends OpportunitieDetailsPage {
    @FindBy(xpath = "//div[contains(@id,'opp3_ileinner')]")
    WebElement getOpportuntiesteName;
    @FindBy(xpath = "//div[contains(@id,'opp9_ileinner')]")
    WebElement getOpportunitiesCloseDate;
    @FindBy(xpath = "//div[contains(@id,'opp11_ileinner')]")
    WebElement getOpportunitiesStage;

    @FindBy(xpath = "//input[@title='New Quote']")
    WebElement newQuoteButton;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public boolean isChangeDisplayed(Opportunitie opportunitie) {
        return driverTools.isElementDisplayed(By.xpath("//div[contains(text(),'" + opportunitie.getAccountName() + "')]"));
    }

    @Override
    public QuotesFormPage isNewQuoteSelect() {
        driverTools.clickElement(newQuoteButton);
        return new QuotesFormPageClassic();
    }
}
