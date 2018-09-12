package com.jalasoft.sfdc.ui.pages.priceBook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceBookFormPageClassic extends PriceBookFormPage {

    @FindBy(xpath = "//input[@id='Name']")
    WebElement titlePriceBookInput;

    @FindBy(xpath = "//input[@id='Description'] ")
    WebElement desriptionInput;

    @FindBy(xpath = "//input[@id='IsActive'] ")
    WebElement optionActiveCheckBox;

    @FindBy(xpath = "//*[@id=\"topButtonRow\"]//child::input[@value=\" Save \"]")
    WebElement saveButton;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for fill and create new price book in the form page Classic.
     * @param title form's fields.
     * @param description form's fields.
     * @return price book's detail created.
     */
    @Override
    public PriceBookDetailsPage clickSavePriceBook(String title, String description) {
        driverTools.setInputField(titlePriceBookInput, title);
        driverTools.setInputField(desriptionInput, description);
        driverTools.clickElement(optionActiveCheckBox);
        driverTools.clickElement(saveButton);
        return new PriceBookDetailsPageClassic();
    }
}
