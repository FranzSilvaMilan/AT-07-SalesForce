package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.ui.pages.ListBasePage;

public abstract class ContactListPage extends ListBasePage {

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    public abstract ContactFormPage gotToNewButton();
    //public abstract ContactFormPage gotToSaveBtn(String newContact);
}
