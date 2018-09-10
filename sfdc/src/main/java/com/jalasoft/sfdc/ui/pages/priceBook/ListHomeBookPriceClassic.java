package com.jalasoft.sfdc.ui.pages.priceBook;

import com.jalasoft.sfdc.ui.pages.ListHomePage;

public class ListHomeBookPriceClassic  extends ListHomePage{
    @Override
    public void clickSaveNewButton() {
        driverTools.clickElement(newButton);
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
