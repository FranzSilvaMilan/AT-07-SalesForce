package com.jalasoft.sfdc.ui.pages.priceBook;

public class PriceBookListPageLight extends PriceBookListPage {

    /**
     * Implement button new in the price book home page Light.
     * @return form create new price book.
     */
    @Override
    public PriceBookFormPage clickButtonNew() {
        driverTools.clickElement(newButton);
        return new PriceBookFormPageLight();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
