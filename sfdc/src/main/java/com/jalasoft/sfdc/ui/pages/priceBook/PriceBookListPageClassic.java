package com.jalasoft.sfdc.ui.pages.priceBook;

public class PriceBookListPageClassic extends PriceBookListPage {

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Implement button new in the price book home page Classic.
     * @return form create new price book.
     */
    @Override
    public PriceBookFormPage clickButtonNew() {
        driverTools.clickElement(newButton);
        return new PriceBookFormPageClassic();
    }
}
