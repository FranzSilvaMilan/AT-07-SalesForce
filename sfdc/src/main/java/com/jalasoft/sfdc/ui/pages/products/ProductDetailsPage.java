package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.ui.BasePage;

/**
 * Product Details Page class.
 *
 * @author Erik Vargas
 */
public abstract class ProductDetailsPage extends BasePage {

    /**
     * Method abstract for validated, that Product was created.
     * @return Product name created.
     */
    public abstract String isProductNameDisplayed();
}
