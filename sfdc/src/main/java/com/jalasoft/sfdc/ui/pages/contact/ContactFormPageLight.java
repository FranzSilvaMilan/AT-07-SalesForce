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
    private Contact contact1;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameTextInput;
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
    @FindBy(xpath = "//textarea[contains(@placeholder,'Mailing Street')]")
    WebElement malingStreetTxtArea;
    @FindBy(xpath = "(//a[@class='select'])[2]")
    WebElement leadSourceCmbBox;
    @FindBy(xpath = "(//input[@class=' input'])[12]")
    WebElement languagesInput;
    @FindBy(xpath = "(//a[@class='select'])[3]")
    WebElement levelCmbBox;
    @FindBy(xpath = "//button[@title='Save']")
    WebElement saveButton;
    @FindBy(xpath = "//span[@class='title'][contains(.,'Details')]")
    WebElement detailsClickOption;


    /**
     * Method that set and save the date of a new Contact.
     *
     * @param contact - is the object that contains the contact's data.
     * @return - new page Light.
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
            driverTools.clickElement(By.xpath("//a[contains(.,'"+contact.getLeadSource()+"')]"));
        }
        driverTools.setInputField(languagesInput, contact.getLenguaje());
        driverTools.clickElement(levelCmbBox);
        driverTools.clickElement(By.xpath("//a[contains(.,'"+contact.getLevel()+"')]"));
        driverTools.setInputField(malingStreetTxtArea, contact.getMailingStreet());
        driverTools.clickElement(saveButton);
        driverTools.waitWebElementInVisibility(saveButton);
        contact.setId(getUrlCurrent(driver.getCurrentUrl()));
        driverTools.clickElement(detailsClickOption);
        return new ContactDetailsPageLight();
    }

    private String getUrlCurrent(String currentUrl){
        String[] currentUrlList = currentUrl.split("/");
        String idUrl = currentUrlList[currentUrlList.length - 2];
        return idUrl;
    }
}
