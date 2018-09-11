package com.jalasoft.sfdc.ui.pages.contact;

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
     * Abstract method that set and save new Contact.
     *
     * @param newContact - last name of the new contact.
     * @return new page.
     */
    public abstract ContactDetailsPage gotToSaveButton(String newContact);
}
