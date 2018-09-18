package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ContacDetailsPageLight class.
 *
 * @author Daniel Sandoval.
 * @since 9/11/2018.
 */
public class ContactDetailsPageLight extends ContactDetailsPage {
    @FindBy(xpath = "(//*[@class='testonly-outputNameWithHierarchyIcon sfaOutputNameWithHierarchyIcon']//child::span)[1]")
    WebElement contactlabelName;
    @FindBy(xpath = "//span[@class='title'][contains(.,'Details')]")
    WebElement detailsClickOption;
    @FindBy(xpath = "//button[contains(@title,'Edit Title')]")
    WebElement editBtn;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement setFirstNameInput;
    @FindBy(xpath = "//input[contains(@placeholder,'Last Name')]")
    WebElement setLastNameInput;
    @FindBy(xpath = "(//input[@class=' input'])[4]")
    WebElement setTitleInput;
    @FindBy(xpath = "(//input[@class=' input'])[3]")
    WebElement setMobileInput;
    @FindBy(xpath = "(//input[@class=' input'])[2]")
    WebElement setHomePhoneInput;
    @FindBy(xpath = "(//input[@class=' input'])[1]")
    WebElement setPhoneInput;
    @FindBy(xpath = "//button[contains(@title,'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//*[text()='Mobile']//parent::div//following::div//child::span//child::span")
    WebElement changeMobile;
    @FindBy(xpath = "//*[text()='Title']//parent::div//following::div//child::span//child::span")
    WebElement changeTitle;

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

    @Override
    public void clickOptionEdit(Contact contact) {
        driverTools.clickElement(editBtn);

        driverTools.clickElement(setTitleInput);
        driverTools.setInputField(setTitleInput, contact.getTitle());
        driverTools.clickElement(setMobileInput);
        driverTools.setInputField(setMobileInput,contact.getMobile());
    }

    @Override
    public void isSaveOfChangeMade() {
        driverTools.clickElement(saveBtn);
    }

    @Override
    public String isMobileChangeDisplayed() {
        System.out.println(changeMobile.getText());
        return changeMobile.getText().trim();
    }

    @Override
    public String isTitleChangeDisplayed() {
        //System.out.println(changeTitle.getText());
        return changeTitle.getText();
    }


}
