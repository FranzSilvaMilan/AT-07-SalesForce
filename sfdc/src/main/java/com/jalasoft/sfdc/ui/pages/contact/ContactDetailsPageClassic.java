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
    private WebElement contactLabelName;
    @FindBy(xpath = "//td[@id='topButtonRow']//child::input[@type='button' and @title='Edit']")
    private WebElement editButton;

    // Xpath for set of the fields
    @FindBy(xpath = "//input[@name='con5']")
    private WebElement setTitleInput;
    @FindBy(xpath = "//input[@name='con12']")
    private WebElement setMobileInput;
    @FindBy(xpath = "//input[contains(@name,'name_firstcon2')]")
    private WebElement setFirstNameInput;
    @FindBy(xpath = "//input[contains(@id,'name_lastcon2')]")
    private WebElement setLastNameInput;

    @FindBy(xpath = "//*[@id='topButtonRow']//child::input[@name='save']")
    private WebElement saveButton;
    @FindBy(xpath = "//div[@id='con5_ileinner']")
    private WebElement getTitleChange;
    @FindBy(xpath = "//div[@id='con12_ileinner']")
    private WebElement getMobileChange;
    @FindBy(xpath = "//*[@id='topButtonRow']//child::input[contains(@value,'Delete')]")
    private WebElement deleteButton;

    /**
     * The method that retrieves the surname.
     * @return - last name.
     */
    @Override
    public String isContactNameDisplayed() {
        return contactLabelName.getText().trim();
    }

    /**
     * Method that you click on the Edit button.
     */
    @Override
    public void clickEditButton() {
        driverTools.clickElement(editButton);
    }

    /**
     * The method allows us to edit the created contact.
     * @param contact - object that contains the contact's data.
     */
    @Override
    public void setNewChangesToContact(Contact contact) {
        driverTools.setInputField(setFirstNameInput, contact.getFirstName());
        driverTools.clickElement(setLastNameInput);
        driverTools.setInputField(setLastNameInput, contact.getLastName());
        driverTools.clickElement(setTitleInput);
        driverTools.setInputField(setTitleInput, contact.getTitle());
        driverTools.clickElement(setMobileInput);
        driverTools.setInputField(setMobileInput, contact.getMobile());
        driverTools.clickElement(saveButton);
    }

    /**
     * The method that delete of the contact
     */
    @Override
    public void clickDeletedButton() {
        driverTools.clickElement(deleteButton);
        acceptAlertDialog();
    }

    /**
     * The name of user is displayed in GUI.
     * @param contact - class object Contact.
     * @return true or false if displayed.
     */
    @Override
    public boolean isNameChangeDisplayed(Contact contact) {
        return driverTools.isElementDisplayed(By.xpath("//div[text()='"+contact.getFirstName()+" "+contact.getLastName()+"']"));
    }

    /**
     * The title of user is displayed in GUI.
     * @param contact - class object Contact.
     * @return true or false if displayed.
     */
    @Override
    public boolean isTitleChangeDisplayed(Contact contact) {
        return driverTools.isElementDisplayed(By.xpath("//div[text()='"+contact.getTitle()+"']"));
    }

    /**
     * The mobile of user is displayed in GUI.
     * @param contact - class object Contact.
     * @return true or false if displayed.
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
        driverTools.waitUntilElementDisplayed(editButton);
    }

    @Override
    public void getIdUrlCurrent(Contact contact){
        String url = driver.getCurrentUrl();
        String[] urlList = url.split("/");
        contact.setId(urlList[urlList.length - 1]);
    }

}
