package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.ui.pages.ListBasePage;

import java.util.List;

/**
 * Product List Page class.
 *
 * @author Erik Vargas
 */
public abstract class ProductListPage extends ListBasePage {

    public  abstract  ProductFormPage clickButtonNew();

    public  abstract  ProductFormPage clickEditBtn();

    public abstract List<String> validateInputs();
}
