package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.ui.BasePage;

/**
 * ContacDetailsPage class.
 *
 * @author Daniel Sandoval.
 * @since 9/11/2018.
 */
public abstract class ContactDetailsPage extends BasePage {

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Abstract method that verify if is created to new Contact.
     *
     * @return - the last name created.
     */
    public abstract String isContactNameDisplayed();
}