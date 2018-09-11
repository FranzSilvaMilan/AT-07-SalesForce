package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.ui.BasePage;

/**
 * Product Form Page class.
 *
 * @author Erik Vargas
 */
public abstract class ProductFormPage extends BasePage {

    public abstract ProductDetails clickSaveProduct(String name);
}
