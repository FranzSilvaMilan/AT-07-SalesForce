package com.jalasoft.sfdc.ui.pages.products;

import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Product List Page Light class.
 *
 * @author Erik Vargas
 */
public class ProductListPageLight extends ProductListPage {

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
    }

    /**
     * Method for implement button new in the product home page Light.
     * @return form create new product.
     */
    @Override
    public ProductFormPage clickButtonNew() {
        driverTools.clickElement(newButton);
        return new ProductFormPageLIght();
    }
}
