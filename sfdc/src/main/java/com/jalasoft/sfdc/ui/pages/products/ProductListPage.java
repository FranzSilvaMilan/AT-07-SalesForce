package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.ui.pages.ListBasePage;

public abstract class ProductListPage extends ListBasePage {

    /**
     * Method abstract for implement click on button new.
     * @return form crete new product.
     */
    public  abstract  ProductFormPage clickButtonNew();
}
