package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.BasePage;

/**
 * ContacFormPage class.
 *
 * @author Daniel Sandoval.
 * @since 9/11/2018.
 */
public abstract class ContactFormPage extends BasePage {

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * The abstract method that set and save new Contact.
     * @param contact - is the object that contains the contact's data.
     * @return new page Classic or Light.
     */
    public abstract ContactDetailsPage gotToSaveButton(Contact contact);
}
