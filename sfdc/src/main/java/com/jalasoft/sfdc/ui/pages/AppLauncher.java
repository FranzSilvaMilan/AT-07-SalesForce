package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.account.AccountHomePage;
import com.jalasoft.sfdc.ui.pages.contact.ContactFormPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageClassic;

public abstract class AppLauncher extends BasePage {

    //public abstract ProductListPage clickProductLink();
    public AccountFormPage gotToAccountPage(){
        return new AccountFormPage();
    }

    public ContactListPage goToContactPage(){
        return new ContactListPageClassic();
    }
}
