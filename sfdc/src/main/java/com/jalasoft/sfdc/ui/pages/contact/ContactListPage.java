package com.jalasoft.sfdc.ui.pages.contact;

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
     * Abstract method that click the New button.
     *
     * @return new page.
     */
    public abstract ContactFormPage gotToNewButton();
}
