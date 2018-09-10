package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.ui.BasePage;

public abstract class ContactFormPage extends BasePage {

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    public abstract ContactDetailsPage gotToSaveButton(String newContact);
}
