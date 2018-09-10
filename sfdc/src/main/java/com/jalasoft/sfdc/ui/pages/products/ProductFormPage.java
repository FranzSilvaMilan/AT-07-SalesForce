package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.ui.BasePage;

public abstract class ProductFormPage extends BasePage {

    /**
     * Method abstract for fill and create new product.
     * @param name form fields.
     * @return product's details created.
     */
    public abstract ProductDetails ClickSaveProduct(String name);
}
