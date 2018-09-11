package com.jalasoft.sfdc.ui.pages.contact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ContacFormPageLight class.
 *
 * @author Daniel Sandoval.
 * @since 9/11/2018
 */
public class ContactFormPageLight extends ContactFormPage {
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameTextInput;
    @FindBy(xpath = "//button[@title='Save']")
    WebElement saveButton;

    /**
     * Method that set and save to new Contact.
     *
     * @param newContact - last name of the new contact.
     * @return - new page Light.
     */
    @Override
    public ContactDetailsPage gotToSaveButton(String newContact) {
        driverTools.setInputField(lastNameTextInput, newContact);
        driverTools.clickElement(saveButton);
        return new ContactDetailsPageLight();
    }
}
