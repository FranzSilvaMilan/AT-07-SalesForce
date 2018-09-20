package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.By;

/**
 * Product List Page Light class.
 *
 * @author Erik Vargas
 */
public class ProductListPageLight extends ProductListPage {

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        driverTools.waitUntilElementDisplayed(newButton);
    }

    /**
     * Method for implement button new in the product home page Light.
     * @return form create new product.
     */
    @Override
    public ProductFormPage clickButtonNew() {
        driverTools.clickElement(newButton);
        return new ProductFormPageLIght();
    }

    @Override
    public boolean validateDelete(Product product) {
        return driverTools.isElementDisplayed(By.xpath("//a[contains(@title,'"+product.getProductName()+"')]"));
    }
}
