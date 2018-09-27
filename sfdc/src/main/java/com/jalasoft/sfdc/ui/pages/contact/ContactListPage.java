package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.pages.ListBasePage;

/**
 * ContactListPage class.
 *
 * @author Daniel Sandoval.
 * @since 9/11/2018.
 */
public abstract class ContactListPage extends ListBasePage {

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * The abstract method that click the New button.
     * @return new page.
     */
    public abstract ContactFormPage gotToNewButton();

    /**
     * The abstract method verifies that the contact has been shown in the list.
     * @param contact - class object Contact.
     * @return true or false if displayed.
     */
    public abstract boolean isContatcNotDisplayed(Contact contact);

    /**
     * The abstract method that you click on a Contact in a Contact list.
     * @param contact - class object Contact.
     * @return new page Classic or Light.
     */
    public abstract ContactDetailsPage clickContactOnList(Contact contact);
}
