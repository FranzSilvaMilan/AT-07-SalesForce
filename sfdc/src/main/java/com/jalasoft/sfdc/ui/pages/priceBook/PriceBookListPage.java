package com.jalasoft.sfdc.ui.pages.priceBook;

import com.jalasoft.sfdc.ui.HomeBasePage;

public abstract class PriceBookListPage extends HomeBasePage {
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

   // @Override
    public abstract PriceBookCreatedPage getClickSavePriceBook(String title, String description);

    //public abstract PriceBookCreatedPage clickSavePriceBook();
}
