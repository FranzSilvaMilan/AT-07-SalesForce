package com.jalasoft.sfdc.ui.pages.opportunities;

import com.jalasoft.sfdc.entities.Opportunitie;
import com.jalasoft.sfdc.ui.pages.quote.QuotesFormPage;
import com.jalasoft.sfdc.ui.pages.quote.QuotesFormPageClassic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunitieDetailsPageClassic extends OpportunitieDetailsPage {
    @FindBy(xpath = "//div[contains(@id,'opp3_ileinner')]")
    private WebElement getOpportuntiesteName;
    @FindBy(xpath = "//div[contains(@id,'opp9_ileinner')]")
    private WebElement getOpportunitiesCloseDate;
    @FindBy(xpath = "//div[contains(@id,'opp11_ileinner')]")
    private WebElement getOpportunitiesStage;

    @FindBy(xpath = "//input[@title='New Quote']")
    private WebElement newQuoteButton;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for validate element displayed.
     * @param opportunitie - is the object that contains the opportunitie's data.
     * @return truo or false when displayed element.
     */
    @Override
    public boolean isChangeDisplayed(Opportunitie opportunitie) {
        return driverTools.isElementDisplayed(By.xpath("//div[contains(text(),'" + opportunitie.getName() + "')]"));
    }

    /**
     * Method for create new quote.
     * @return Quotes Form Page Classic.
     */
    @Override
    public QuotesFormPage isNewQuoteSelect() {
        driverTools.clickElement(newQuoteButton);
        return new QuotesFormPageClassic();
    }

    @Override
    public void getIdOpportunity(Opportunitie opportunitie) {
        String url = driver.getCurrentUrl();
        String[] urlSplit = url.split("/");
        opportunitie.setId(urlSplit[urlSplit.length - 1]);
    }
}
