package com.jalasoft.sfdc.ui.pages.contact;

/**
 * ContactListPageClassic class.
 *
 * @author Daniel Sandoval.
 * @since 9/11/2018.
 */
public class ContactListPageClassic extends ContactListPage {

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method that clicks on the option of the New button.
     *
     * @return - new page Classic.
     */
    @Override
    public ContactFormPage gotToNewButton() {
        driverTools.clickElement(newAccountButton);
        return new ContactFormPageClassic();
    }
}