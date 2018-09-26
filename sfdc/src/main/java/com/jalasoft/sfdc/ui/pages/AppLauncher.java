package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitieListPage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookListPage;
import com.jalasoft.sfdc.ui.pages.products.ProductListPage;

/**
 * AppLauncher class.
 *
 * @author Franz Silva.
 * @author Erik Vargas.
 * @author Daniel Sandoval.
 */
public abstract class AppLauncher extends BasePage {

    public abstract AccountListPage gotToAccountPage();
    public abstract ContactListPage goToContactPage();
    public abstract ProductListPage goToProductPage();
    public abstract PriceBookListPage goToPriceBookPage();
    public abstract OpportunitieListPage goToOpportunitiesPage();
}
