package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ContacDetailsPageClassic class.
 *
 * @author Daniel Sandoval.
 * @since 9/11/2018.
 */
public class ContactDetailsPageClassic extends ContactDetailsPage {
    @FindBy(xpath = "//h2[contains(@class,'topName')]")
    WebElement contactLabelName;
    @FindBy(xpath = "//td[@id='topButtonRow']//child::input[@type='button' and @title='Edit']")
    WebElement editButton;
    /**
     * Xpath for set of the fields
     */
    @FindBy(xpath = "//input[@name='con5']")
    WebElement setTitleInput;
    @FindBy(xpath = "//input[@name='con12']")
    WebElement setMobileInput;
    @FindBy(xpath = "//input[contains(@name,'name_firstcon2')]")
    WebElement setFirstNameInput;
    @FindBy(xpath = "//input[contains(@id,'name_lastcon2')]")
    WebElement setLastNameInput;
    /**
     * Xpath for get fields and save changes.
     */
    @FindBy(xpath = "//*[@id='topButtonRow']//child::input[@name='save']")
    WebElement saveButton;
    @FindBy(xpath = "//div[@id='con5_ileinner']")
    WebElement getTitleChange;
    @FindBy(xpath = "//div[@id='con12_ileinner']")
    WebElement getMobileChange;

    @FindBy(xpath = "//*[@id='topButtonRow']//child::input[contains(@value,'Delete')]")
    WebElement deleteButton;

    /**
     * Method that get the last name created.
     *
     * @return - last name.
     */
    @Override
    public String isContactNameDisplayed() {
        return contactLabelName.getText().trim();
    }

    /**
     * The method allows us to edit the created contact.
     * @param contact - is the object that contains the contact's data.
     */
    @Override
    public void clickOptionEditButton(Contact contact) {
        driverTools.clickElement(editButton);
        driverTools.clickElement(setFirstNameInput);
        driverTools.setInputField(setFirstNameInput, contact.getFirstName());
        driverTools.clickElement(setLastNameInput);
        driverTools.setInputField(setLastNameInput, contact.getLastName());
        driverTools.clickElement(setTitleInput);
        driverTools.setInputField(setTitleInput, contact.getTitle());
        driverTools.clickElement(setMobileInput);
        driverTools.setInputField(setMobileInput, contact.getMobile());
    }

    /**
     * Save of changes mades.
     */
    @Override
    public void isSaveOfChangeMade() {
        driverTools.clickElement(saveButton);
    }

    /**
     * The method that delete of the contact
     */
    @Override
    public void clickOptionDelet() {
        driverTools.clickElement(deleteButton);
        acceptAlertDialog();
    }

    /**
     * The name of user is displayed in GUI.
     * @param contact - class object Contact.
     * @return if is displayed true or false.
     */
    @Override
    public boolean isNameChangeDisplayed(Contact contact) {
        return driverTools.isElementDisplayed(By.xpath("//div[text()='"+contact.getFirstName()+" "+contact.getLastName()+"']"));
    }

    /**
     * The title of user is displayed in GUI.
     * @param contact - class object Contact.
     * @return if is displayed true or false.
     */
    @Override
    public boolean isTitleChangeDisplayed(Contact contact) {
        return driverTools.isElementDisplayed(By.xpath("//div[text()='"+contact.getTitle()+"']"));
    }

    /**
     * The mobile of user is displayed in GUI.
     * @param contact - class object Contact.
     * @return if is displayed true or false.
     */
    @Override
    public boolean isMobileChangeDisplayed(Contact contact) {
        return driverTools.isElementDisplayed(By.xpath("//div[text()='"+contact.getMobile()+"']"));
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
