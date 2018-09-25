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
     * Method that clicks on the option of the New button.
     *
     * @return - new page Light.
     */
    @Override
    public ContactFormPage gotToNewButton() {
        driverTools.clickElement(newButton);
        return new ContactFormPageLight();
    }

    /**
     * The name of user is displayed.
     * @param contact - class object Contact.
     * @return if is displayed true or false.
     */
    @Override
    public boolean isContatcNotDisplayed(Contact contact) {
        return driverTools.isElementDisplayed(By.xpath("//a[contains(.,'"+contact.getFirstName()+" "+contact.getLastName()+"')]"));
    }

    /**
     * Selection a contact crete of contact List.
     * @param contact - class object Contact.
     * @return contact details page light.
     */
    @Override
    public ContactDetailsPage clickContactOnList(Contact contact) {
        String accountXpath = "//a[contains(@class, 'slds-truncate') and contains(@title, '" + contact.getFirstName()+" "+contact.getLastName() + "')]";
        driverTools.refreshPage();
        driverTools.clickElement(By.xpath(accountXpath));
        return new ContactDetailsPageLight();
    }
}
