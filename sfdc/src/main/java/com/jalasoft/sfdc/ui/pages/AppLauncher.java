package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.account.AccountHomePage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookFormPage;

public abstract class AppLauncher extends BasePage {

    //public abstract ProductListPage clickProductLink();
    public AccountFormPage gotToAccountPage(){

        return new AccountFormPage();
    }
    public abstract PriceBookFormPage gotToPriceBookPage();
}
