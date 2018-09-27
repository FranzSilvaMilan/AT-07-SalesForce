package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
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
    private WebElement lastNameTextInput;
    @FindBy(xpath = "//*[@id='topButtonRow']/child::input[@title='Save']")
    private WebElement saveButton;
    @FindBy(xpath = "//*[@id='name_firstcon2']")
    private WebElement firstnameInput;
    @FindBy(xpath = "//*[@id='con10']")
    private WebElement phoneInput;
    @FindBy(xpath = "//*[@id='con13']")
    private WebElement homePhoneInput;
    @FindBy(xpath = "//*[@id='con12']")
    private WebElement mobileInput;
    @FindBy(xpath = "//*[@id='con5']")
    private WebElement titleInput;
    @FindBy(xpath = "//*[@id='con14']")
    private WebElement otherPhoneInput;
    @FindBy(xpath = "//*[@class='form-element']//child::input")
    private WebElement birthdateInput;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * The method that set and save the date of a new Contact.
     * @param contact - is the object that contains the contact's data.
     * @return - new Classic page Classic.
     */
    @Override
    public ContactDetailsPage gotToSaveButton(Contact contact) {
        driverTools.setInputField(lastNameTextInput, contact.getLastName());
        driverTools.setInputField(firstnameInput, contact.getFirstName());
        driverTools.setInputField(phoneInput, contact.getPhone());
        driverTools.setInputField(homePhoneInput, contact.getHomePhone());
        driverTools.setInputField(mobileInput, contact.getMobile());
        driverTools.setInputField(titleInput, contact.getTitle());
        driverTools.setInputField(otherPhoneInput, contact.getOtherPhone());
        driverTools.scrollToBottomOfPage();
        driverTools.clickElement(saveButton);
        return new ContactDetailsPageClassic();
    }
}
