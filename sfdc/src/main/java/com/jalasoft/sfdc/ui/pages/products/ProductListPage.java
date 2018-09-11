package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.ui.pages.ListBasePage;

/**
 * Product List Page class.
 *
 * @author Erik Vargas
 */
public abstract class ProductListPage extends ListBasePage {

    /**
     * Method abstract, for implement button new.
     * @return form create new product.
     */
    public  abstract  ProductFormPage clickButtonNew();
}
