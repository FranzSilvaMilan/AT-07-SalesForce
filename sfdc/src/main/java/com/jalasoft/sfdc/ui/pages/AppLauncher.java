package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;

import com.jalasoft.sfdc.ui.pages.products.ProductListPage;


public abstract class AppLauncher extends BasePage {

    public abstract AccountListPage gotToAccountPage();
    public abstract ContactListPage goToContactPage();

    /**
     * Method abstract for go to Product home page.
     * @return form crete new product.
     */
    public abstract ProductListPage goToProductPage();

}
