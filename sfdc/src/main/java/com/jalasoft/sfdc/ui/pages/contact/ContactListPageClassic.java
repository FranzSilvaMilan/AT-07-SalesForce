package com.jalasoft.sfdc.ui.pages.contact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
