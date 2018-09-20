package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.BasePage;

/**
 * Product Form Page class.
 *
 * @author Erik Vargas
 */
public abstract class ProductFormPage extends BasePage {

    public abstract ProductDetailsPage clickSaveProduct(Product product);
    public abstract ProductDetailsPage clickSaveEditProduct(Product product);
}
