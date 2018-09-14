package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.ui.BasePage;

import java.util.List;

/**
 * Product Details Page class.
 *
 * @author Erik Vargas
 */
public abstract class ProductDetailsPage extends BasePage {

    public abstract String isProductNameDisplayed();

    public  abstract  ProductFormPage clickEditBtn1();

    public abstract List<String> validateInputs1();
}
