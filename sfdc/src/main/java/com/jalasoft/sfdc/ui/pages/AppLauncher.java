package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.account.AccountHomePage;
import com.jalasoft.sfdc.ui.pages.products.ProducHomePageLight;
import com.jalasoft.sfdc.ui.pages.products.ProductHomePage;

public abstract class AppLauncher extends BasePage {

    //public abstract ProductListPage goToProductPage();
    public AccountFormPage gotToAccountPage(){

        return new AccountFormPage();
    }

    /**
     * Method abstract for go to Product home page.
     * @return form crete new product.
     */
    public abstract ProductHomePage goToProductPage();
}
