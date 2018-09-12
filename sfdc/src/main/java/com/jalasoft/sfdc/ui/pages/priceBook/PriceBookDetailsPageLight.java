package com.jalasoft.sfdc.ui.pages.priceBook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceBookDetailsPageLight extends PriceBookDetailsPage {
    @FindBy(xpath = "(//span[@class='uiOutputText'])[2]")
    WebElement priceBookNameLabel;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for validated that Price book was created in the Price book detail Page Light.
     * @return price book name created.
     */
    @Override
    public String isPriceBookNameDisplayed() {
        return priceBookNameLabel.getText();
    }
}
