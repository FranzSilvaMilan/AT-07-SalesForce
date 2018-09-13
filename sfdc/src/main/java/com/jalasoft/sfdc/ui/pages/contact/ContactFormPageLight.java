package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ContacFormPageLight class.
 *
 * @author Daniel Sandoval.
 * @since 9/11/2018.
 */
public class ContactFormPageLight extends ContactFormPage {
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameTextInput;
    @FindBy(xpath = "//button[@title='Save']")
    WebElement saveButton;
    @FindBy(xpath = "//input[contains(@placeholder,'First Name')]")
    WebElement firstnameInput;
    @FindBy(xpath = "(//input[@class=' input'])[1]")
    WebElement phoneInput;
    @FindBy(xpath = "(//input[@class=' input'])[2]")
    WebElement homePhoneInput;
    @FindBy(xpath = "(//input[@class=' input'])[3]")
    WebElement mobileInput;
    @FindBy(xpath = "(//input[@class=' input'])[4]")
    WebElement titleInput;
    @FindBy(xpath = "(//input[@class=' input'])[5]")
    WebElement otherPhoneInput;



    /**
     * Method that set and save the date of a new Contact.
     *
     * @param contact - is the object that contains the contact's data.
     * @return - new page Light.
     */
    @Override
    public ContactDetailsPage gotToSaveButton(Contact contact) {
        driverTools.setInputField(lastNameTextInput, contact.getLastName());
        driverTools.setInputField(firstnameInput, contact.getFirstName());
        driverTools.setInputField(phoneInput, contact.getPhone());
        driverTools.setInputField(homePhoneInput, contact.getHomePhone());
        driverTools.setInputField(mobileInput, contact.getMobile());
        driverTools.setInputField(titleInput, contact.getTitle());
        driverTools.setInputField(otherPhoneInput,contact.getOtherPhone());
        driverTools.clickElement(saveButton);
        return new ContactDetailsPageLight();
    }
}
