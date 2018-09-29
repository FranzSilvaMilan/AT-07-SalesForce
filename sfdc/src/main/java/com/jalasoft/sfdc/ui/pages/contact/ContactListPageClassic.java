package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ContactListPageClassic class.
 *
 * @author Daniel Sandoval.
 * @since 9/11/2018.
 */
public class ContactListPageClassic extends ContactListPage {
    private static final String BUTTON_EXIT = "//*[@id='tryLexDialogX']";
    @FindBy(xpath = BUTTON_EXIT)
    private WebElement closeWindows;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        driverTools.waitUntilElementDisplayed(newButton);
    }

    /**
     * The method that clicks on the option of the New button.
     * @return - new Form page classic.
     */
    @Override
    public ContactFormPage gotToNewButton() {
        if(driverTools.isElementDisplayed(closeWindows)) {
            driverTools.clickElement(closeWindows);
        }
        driverTools.clickElement(newButton);
        return new ContactFormPageClassic();
    }

    /**
     * The name of user is displayed in the Contacts list.
     * @param contact - class object Contact.
     * @return true or false if displayed.
     */
    @Override
    public boolean isContatcNotDisplayed(Contact contact) {
        return driverTools.isElementDisplayed(By.xpath("//*[@id='mru0030b0000269Gfp']/child::a//following-sibling::span[text()='"+contact.getFirstName()+" "+contact.getLastName()+"']"));
    }

    /**
     * Selection a contact crete of contact List.
     * @param contact - class object Contact.
     * @return new Details page classic.
     */
    @Override
    public ContactDetailsPage clickContactOnList(Contact contact) {
        String accountXpath = "//*[@class=' dataCell  ']//child::a[contains(text(),'" + contact.getLastName()+", "+contact.getFirstName() + "')]";
        System.out.println(accountXpath + " --------------------------------");
        driverTools.refreshPage();
        driverTools.clickElement(By.xpath(accountXpath));
        return new ContactDetailsPageClassic();
    }
}
