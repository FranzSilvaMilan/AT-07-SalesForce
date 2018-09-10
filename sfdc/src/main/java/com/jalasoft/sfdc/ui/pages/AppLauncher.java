package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;

import com.jalasoft.sfdc.ui.pages.account.AccountHomePage;
import com.jalasoft.sfdc.ui.pages.contact.ContactFormPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageClassic;

import com.jalasoft.sfdc.ui.pages.products.ProductListPage;


public abstract class AppLauncher extends BasePage {

    //public abstract ProductListPage goToProductPage();
    public AccountFormPage gotToAccountPage(){
        return new AccountFormPage();
    }


    public ContactListPage goToContactPage(){
        return new ContactListPageClassic();
    }

    /**
     * Method abstract for go to Product home page.
     * @return form crete new product.
     */
    public abstract ProductListPage goToProductPage();

}
