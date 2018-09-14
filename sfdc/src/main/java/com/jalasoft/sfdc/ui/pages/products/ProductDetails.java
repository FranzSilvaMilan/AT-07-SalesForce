package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.ui.BasePage;

import java.util.List;

/**
 * Product Details Page class.
 *
 * @author Erik Vargas
 */
public abstract class ProductDetails extends BasePage {

    public abstract String isProductNameDisplayed();
    public abstract List<String> validateInputs();
    public abstract boolean validateCheckBox();
}
