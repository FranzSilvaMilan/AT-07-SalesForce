package com.jalasoft.sfdc.ui.pages.contact;

public class ContactListPageClassic extends ContactListPage {

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public ContactFormPage gotToNewButton() {
        driverTools.clickElement(newAccountButton);
        return new ContactFormPageClassic();
    }
}
