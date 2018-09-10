package com.jalasoft.sfdc.ui.pages.contact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactFormPageClassic extends ContactFormPage {

    @FindBy(xpath = "//*[@id=\"name_lastcon2\"]")
    WebElement lastNameTextInput;
    @FindBy(xpath = "//*[@id=\"topButtonRow\"]/input[1]")
    WebElement saveButton;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public ContactDetailsPage gotToSaveButton(String newContact) {
        driverTools.setInputField(lastNameTextInput, newContact);
        driverTools.clickElement(saveButton);
        return new ContactDetailsPageClassic();
    }
}
