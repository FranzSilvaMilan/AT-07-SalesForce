package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.ui.pages.ListHomePage;

public abstract class ProductListPage extends ListHomePage {

    /**
     * Method abstract for implement click on button new.
     * @return form crete new product.
     */
    public  abstract  ProductFormPage clickButtonNew();
}
