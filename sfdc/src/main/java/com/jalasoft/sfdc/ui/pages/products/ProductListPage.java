package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.pages.ListBasePage;

/**
 * Product List Page class.
 * @author Erik Vargas
 */
public abstract class ProductListPage extends ListBasePage {

    public abstract ProductFormPage clickButtonNew();
    public abstract boolean validateDelete(Product product);
    public abstract ProductDetailsPage clickProductOnList(Product product);
}
