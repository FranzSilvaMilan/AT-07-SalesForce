package com.jalasoft.sfdc.ui.pages.priceBook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceBookFormPageLight extends PriceBookFormPage {

    @FindBy(xpath = "//*[@aria-required='true']")
    private WebElement titlePriceBookInput;

    @FindBy(xpath = "(//*[@class=' input'])[2]")
    private WebElement desriptionInput;

    @FindBy(xpath = "(//*[@class='slds-form-element__control']//child::input[@type='checkbox']")
    private WebElement optionActiveCheckBox;

    @FindBy(xpath = "//div/button[3]/span")
    private WebElement saveButton;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for fill and create new price book in the form page Light.
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
        return new PriceBookDetailsPageLight();
    }
}
