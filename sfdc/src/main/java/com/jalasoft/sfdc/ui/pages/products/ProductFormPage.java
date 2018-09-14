package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.BasePage;

import java.util.List;

/**
 * Product Form Page class.
 *
 * @author Erik Vargas
 */
public abstract class ProductFormPage extends BasePage {

    /**
     * Method abstract for fill and create new product.
     * @param product form fields.
     * @return product's detail created.
     */
    public abstract ProductDetailsPage clickSaveProduct(Product product);

    public abstract ProductListPage clickSaveEditProduct(Product product);

    public abstract ProductDetailsPage clickSaveEditProduct1(Product product);

}
