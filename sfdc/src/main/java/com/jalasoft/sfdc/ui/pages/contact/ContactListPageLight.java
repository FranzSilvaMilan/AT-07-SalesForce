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

    @Override
    public boolean isContatcNotDisplayed(Contact contact) {
        return driverTools.isElementDisplayed(By.xpath("//a[contains(.,'"+contact.getFirstName()+" "+contact.getLastName()+"')]"));
    }
}
