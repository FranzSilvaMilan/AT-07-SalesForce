package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.By;

/**
 * Product List Page Light class.
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

    /**
     * Method for validate that Product was deleted.
     * @param product field product list.
     * @return element to validate.
     */
    @Override
    public boolean validateDelete(Product product) {
        return driverTools.isElementDisplayed(By.xpath("//a[contains(@title,'"+product.getProductName()+"')]"));
    }

    /**
     * Method for edit Product.
     * @param product field list.
     * @return product detail page.
     */
    @Override
    public ProductDetailsPage clickProductOnList(Product product) {
        String productXpath = "//a[contains(.,'"+product.getProductName()+"')]";
        driverTools.refreshPage();
        driverTools.moveAndClickElement(By.xpath(productXpath));
        return new ProductDetailsPageLight();
    }
}
