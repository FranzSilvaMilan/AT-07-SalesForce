package com.jalasoft.sfdc.ui.pages.contact;

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
        driverTools.clickElement(newAccountButton);
        return new ContactFormPageLight();
    }
}