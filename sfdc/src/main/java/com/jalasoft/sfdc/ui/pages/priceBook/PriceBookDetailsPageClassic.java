package com.jalasoft.sfdc.ui.pages.priceBook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceBookDetailsPageClassic extends PriceBookDetailsPage {
    @FindBy(xpath = "(//*[@class=\"bPageTitle\"]//child::h2")
    WebElement priceBookNameLabel;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for validated that Price book was created in the Price book detail Page Classic.
     * @return price book name created.
     */
    @Override
    public String isPriceBookNameDisplayed() {
        return priceBookNameLabel.getText();
    }
}
