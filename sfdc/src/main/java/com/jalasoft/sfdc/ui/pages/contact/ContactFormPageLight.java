package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.By;
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
    private WebElement lastNameTextInput;
    @FindBy(xpath = "//input[contains(@placeholder,'First Name')]")
    private WebElement firstnameInput;
    @FindBy(xpath = "//span[text()='Phone']/parent::label/following-sibling::input")
    private WebElement phoneInput;
    @FindBy(xpath = "//span[text()='Home Phone']/parent::label/following-sibling::input")
    private WebElement homePhoneInput;
    @FindBy(xpath = "//span[text()='Mobile']/parent::label/following-sibling::input")
    private WebElement mobileInput;
    @FindBy(xpath = "//span[text()='Title']/parent::label/following-sibling::input")
    private WebElement titleInput;
    @FindBy(xpath = "//span[text()='Other Phone']/parent::label/following-sibling::input")
    private WebElement otherPhoneInput;
    @FindBy(xpath = "//textarea[contains(@placeholder,'Mailing Street')]")
    private WebElement malingStreetTxtArea;
    @FindBy(xpath = "(//a[@class='select'])[2]")
    private WebElement leadSourceCmbBox;
    @FindBy(xpath = "//span[text()='Languages']/parent::label/following-sibling::input")
    private WebElement languagesInput;
    @FindBy(xpath = "(//a[@class='select'])[3]")
    private WebElement levelCmbBox;
    @FindBy(xpath = "//button[@title='Save']")
    private WebElement saveButton;
    @FindBy(xpath = "//span[@class='title'][contains(.,'Details')]")
    private WebElement detailsClickOption;

    private static final String EMENT_DISPAYED_COMBO_BOX_LEVEL = "//a[contains(.,'%s')]";
    private static final String EMENT_DISPAYED_COMBO_BOX_LEAD_SOURCE = "//a[contains(.,'%s')]";

    /**
     * The method that set and save the date of a new Contact.
     * @param contact - is the object that contains the contact's data.
     * @return - new Details page Light.
     */
    @Override
    public ContactDetailsPage gotToSaveButton(Contact contact) {
        driverTools.setInputField(firstnameInput, contact.getFirstName());
        driverTools.setInputField(lastNameTextInput, contact.getLastName());
        driverTools.setInputField(phoneInput, contact.getPhone());
        driverTools.setInputField(homePhoneInput, contact.getHomePhone());
        driverTools.setInputField(titleInput, contact.getTitle());
        driverTools.setInputField(mobileInput, contact.getMobile());
        driverTools.setInputField(otherPhoneInput,contact.getOtherPhone());
        driverTools.clickElement(leadSourceCmbBox);
        if(!contact.getLeadSource().isEmpty()){
            driverTools.clickElement(By.xpath(String.format(EMENT_DISPAYED_COMBO_BOX_LEAD_SOURCE,contact.getLeadSource())));
        }
        driverTools.setInputField(languagesInput, contact.getLenguaje());
        driverTools.clickElement(levelCmbBox);
        driverTools.clickElement(By.xpath(String.format(EMENT_DISPAYED_COMBO_BOX_LEVEL,contact.getLevel())));
        driverTools.setInputField(malingStreetTxtArea, contact.getMailingStreet());
        driverTools.clickElement(saveButton);
        driverTools.clickElement(detailsClickOption);
        return new ContactDetailsPageLight();
    }
}
