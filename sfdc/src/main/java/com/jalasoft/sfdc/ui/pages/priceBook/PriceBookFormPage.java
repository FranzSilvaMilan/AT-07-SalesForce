package com.jalasoft.sfdc.ui.pages.priceBook;

import com.jalasoft.sfdc.ui.HomeBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class PriceBookFormPage extends HomeBasePage {

    @Override
    public  void waitUntilPageObjectIsLoaded() {

    }

    public abstract PriceBookListPage clickNewButton();
    /*{
        driverTools.clickElement(newAccountButton);
    }
*/
    //public abstract PriceBookListPage getClickSavePriceBook();


}
