package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.BasePage;

import java.util.List;

/**
 * Product Details Page class.
 *
 * @author Erik Vargas
 */
public abstract class ProductDetailsPage extends BasePage {

    public abstract String isProductNameDisplayed();
    public abstract List<String> validateInputs();
    public abstract boolean validateCheckBox();
    public abstract ProductFormPage clickEditBtn();
    public abstract void clickDeleteButton();
    public abstract boolean validateDelete(Product product);
    public abstract ProductDetailsPage clickAddPriceStandard(String priceStandard);
    public abstract ProductDetailsPage clickAddPriceBook(String priceBook);

    public abstract void getIdProduct(Product product);
}
