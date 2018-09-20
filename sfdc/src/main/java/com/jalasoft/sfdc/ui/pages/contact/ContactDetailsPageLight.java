package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * ContacDetailsPageLight class.
 *
 * @author Daniel Sandoval.
 * @since 9/11/2018.
 */
public class ContactDetailsPageLight extends ContactDetailsPage {
    private List<String> contenedor = new ArrayList<>();

    @FindBy(xpath = "(//*[@class='testonly-outputNameWithHierarchyIcon sfaOutputNameWithHierarchyIcon']//child::span)[1]")
    WebElement contactlabelName;
    @FindBy(xpath = "//span[@class='title'][contains(.,'Details')]")
    WebElement detailsClickOption;
    @FindBy(xpath = "//*[text()='Phone']//parent::div//following-sibling::div//child::span")
    WebElement phoneValidedText;
    @FindBy(xpath = "//*[text()='Name']//parent::div//following-sibling::div//child::span")
    WebElement nameValidedText;
    @FindBy(xpath = "//*[text()='Home Phone']//parent::div//following-sibling::div//child::span")
    WebElement homePhoneValidedText;
    @FindBy(xpath = "//*[text()='Mobile']//parent::div//following-sibling::div//child::span")
    WebElement mobileValidedText;
    @FindBy(xpath = "//*[text()='Other Phone']//parent::div//following-sibling::div//child::span")
    WebElement otherPhoneValidedText;
    @FindBy(xpath = "//*[text()='Title']//parent::div//following-sibling::div//child::span")
    WebElement titleValidedText;
    @FindBy(xpath = "//*[text()='Lead Source']//parent::div//following-sibling::div//child::span")
    WebElement leadSourceValidedText;
    @FindBy(xpath = "//*[text()='Mailing Address']//parent::div//following-sibling::div//child::span")
    WebElement mailingAddressValidedText;
    @FindBy(xpath = "//button[contains(@title,'Edit Title')]")
    WebElement editButton;

    /**
     * Xpath for set a new attributs of the contact.
     */
    @FindBy(xpath = "//*[text()='First Name']//parent::label//following-sibling::input")
    WebElement setFirstNameInput;
    @FindBy(xpath = "//*[text()='Last Name']//parent::label//following-sibling::input")
    WebElement setLastNameInput;
    @FindBy(xpath = "//*[text()='Title']//parent::label//following-sibling::input")
    WebElement setTitleInput;
    @FindBy(xpath = "//*[text()='Mobile']//parent::label//following-sibling::input")
    WebElement setMobileInput;

    @FindBy(xpath = "//button[contains(@title,'Save')]")
    WebElement saveButton;
    /**
     * //*[text()='Name']/../following-sibling::div//child::span[@class="uiOutputText"] -- Name
     * //*[text()='Title']/../following-sibling::div//child::span[@class="uiOutputText"] -- Title
     * //*[text()='Languages']/../following-sibling::div//child::span[@class="uiOutputText"] -- Languaje
     */

    /**
     * Xpath for delete contact.
     */
    @FindBy(xpath = "//*[@class='slds-col slds-no-flex slds-grid slds-align-middle actionsContainer']//following-sibling::ul//following-sibling::li[@class='slds-button slds-button--icon-border-filled oneActionsDropDown']//child::div//child::div//child::div//child::div//child::a[@title='Show 5 more actions']")
    WebElement showMoreActionCombobox;
    @FindBy(xpath = "//a[contains(@title,'Delete')]")
    WebElement deletOption;
    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement confirmarDelete;

    /**
     * Method that get the last name created.
     *
     * @return - last name.
     */
    @Override
    public String isContactNameDisplayed() {
        driverTools.clickElement(detailsClickOption);
        return contactlabelName.getText().trim();
    }

    public List<String> camposValidados() {
        contenedor.add(nameValidedText.getText());
        contenedor.add(phoneValidedText.getText());
        contenedor.add(homePhoneValidedText.getText());
        contenedor.add(mobileValidedText.getText());
        contenedor.add(otherPhoneValidedText.getText());
        contenedor.add(titleValidedText.getText());
        contenedor.add(leadSourceValidedText.getText());
        contenedor.add(mailingAddressValidedText.getText());
        return contenedor;
    }

    /**
     * The method allows us to edit the created contact.
     * @param contact - is the object that contains the contact's data.
     */
    @Override
    public void clickOptionEditButton(Contact contact) {
        driverTools.clickElement(detailsClickOption);
        driverTools.clickElement(editButton);
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

    @Override
    public boolean isNameChangeDisplayed(Contact contact){
        return driverTools.isElementDisplayed(By.xpath("//span[text()='Name']/../following-sibling::div//child::span[text()='"+contact.getFirstName()+" "+contact.getLastName()+"']"));
    }
    @Override
    public boolean isTitleChangeDisplayed(Contact contact){
        return driverTools.isElementDisplayed(By.xpath("(//span[text()='Title'])/../following-sibling::div//child::span[text()='"+contact.getTitle()+"']"));
    }
    @Override
    public boolean isMobileChangeDisplayed(Contact contact){
        return driverTools.isElementDisplayed(By.xpath("(//span[text()='Mobile'])/../following-sibling::div//child::span[text()='"+contact.getMobile()+"']"));
    }


    /**
     * The method that delete of the contact
     */
    @Override
    public void clickOptionDelet() {
        driverTools.clickElement(detailsClickOption);
        driverTools.moveAndClickElement(showMoreActionCombobox);
        driverTools.clickElement(deletOption);
        driverTools.clickElement(confirmarDelete);
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
