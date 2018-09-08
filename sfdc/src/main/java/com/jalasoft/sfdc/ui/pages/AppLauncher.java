package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookPage;

public abstract class AppLauncher extends BasePage {

    //public abstract ProductListPage clickProductLink();
    public AccountFormPage gotToAccountPage(){

        return new AccountFormPage();
    }
    public abstract PriceBookPage gotToPriceBookPage();
}
