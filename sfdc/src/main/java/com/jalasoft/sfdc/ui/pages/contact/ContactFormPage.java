package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.ui.HomeBasePage;
import com.jalasoft.sfdc.ui.pages.ListHomePage;

public abstract class ContactFormPage extends ListHomePage {

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    public abstract ContactDetailsPage gotToSaveButton(String newContact);
}
