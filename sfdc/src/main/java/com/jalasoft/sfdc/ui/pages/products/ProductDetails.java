package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.ui.BasePage;

public abstract class ProductDetails extends BasePage {
    /**
     * Method abstract for validated that Product was created.
     * @return Product name created.
     */
    public abstract String isProductNameDisplayed();
}
