package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.By;

/**
 * ContactListPageLight class.
 *
 * @author Daniel Sandoval.
 * @since 9/11/2018.
 */
public class ContactListPageLight extends ContactListPage {

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        driverTools.waitUntilElementDisplayed(newButton);
    }

    /**
     * The method that clicks on the option of the New button.
     * @return - new Form page Light.
     */
    @Override
    public ContactFormPage gotToNewButton() {
        driverTools.clickElement(newButton);
        return new ContactFormPageLight();
    }

    /**
     * The name of user is displayed in the Contacts list.
     * @param contact - class object Contact.
     * @return true or false if displayed..
     */
    @Override
    public boolean isContatcNotDisplayed(Contact contact) {
        return driverTools.isElementDisplayed(By.xpath("//a[contains(.,'"+contact.getFirstName()+" "+contact.getLastName()+"')]"));
    }

    /**
     * Selection a contact crete of contact List.
     * @param contact - class object Contact.
     * @return new Details page Light.
     */
    @Override
    public ContactDetailsPage clickContactOnList(Contact contact) {
        String accountXpath = "//a[contains(@class, 'slds-truncate') and contains(@title, '" + contact.getFirstName()+" "+contact.getLastName() + "')]";
        driverTools.refreshPage();
        driverTools.clickElement(By.xpath(accountXpath));
        return new ContactDetailsPageLight();
    }
}
