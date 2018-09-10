package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.ListHomePage;

public abstract class ContactListPage extends ListHomePage {

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    public abstract ContactFormPage gotToNewButton();
    //public abstract ContactFormPage gotToSaveBtn(String newContact);
}
