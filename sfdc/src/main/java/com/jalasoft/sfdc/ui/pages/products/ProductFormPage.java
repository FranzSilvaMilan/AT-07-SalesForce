package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.ui.BasePage;

/**
 * Product Form Page class.
 *
 * @author Erik Vargas
 */
public abstract class ProductFormPage extends BasePage {

    /**
     * Method abstract for fill and create new product.
     * @param name form fields.
     * @return product's detail created.
     */
    public abstract ProductDetailsPage clickSaveProduct(String name);
}
