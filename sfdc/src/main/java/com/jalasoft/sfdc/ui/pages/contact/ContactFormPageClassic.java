package com.jalasoft.sfdc.ui.pages.contact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ContacFormPageClassic class.
 *
 * @author Daniel Sandoval.
 * @since 9/11/2018.
 */
public class ContactFormPageClassic extends ContactFormPage {

    @FindBy(xpath = "//*[@id='name_lastcon2']")
    WebElement lastNameTextInput;
    @FindBy(xpath = "//*[@id='topButtonRow']/input[1]")
    WebElement saveButton;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method that set and save to new Contact.
     *
     * @param newContact - last name of the new contact.
     * @return - new page Classic.
     */
    @Override
    public ContactDetailsPage gotToSaveButton(String newContact) {
        driverTools.setInputField(lastNameTextInput, newContact);
        driverTools.clickElement(saveButton);
        return new ContactDetailsPageClassic();
    }
}