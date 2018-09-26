package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Product List Page Classic class.
 * @author Erik Vargas
 */
public class ProductListPageClassic extends ProductListPage {

    @FindBy(css = "#tryLexDialogX")
    private WebElement closePopupButton;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for implement button new in the product list page Classic.
     * @return form create new product.
     */
    @Override
    public ProductFormPage clickButtonNew() {
        clickClosePopup();
        driverTools.clickElement(newButton);
        return new ProductFormPageClassic();
    }
    @Override
    public boolean validateDelete(Product product) {
        return false;
    }

    /**
     * Method for edit Product.
     * @param product field list.
     * @return product detail page.
     */
    @Override
    public ProductDetailsPage clickProductOnList(Product product) {
        clickClosePopup();
        String productXpath = "//a[contains(.,'"+product.getProductName()+"')]";
        driverTools.refreshPage();
        driverTools.clickElement(By.xpath(productXpath));
        return new ProductDetailsPageClassic();
    }

    /**
     * Method for close Popup.
     */
    private void clickClosePopup(){
        if(driverTools.isElementDisplayed(closePopupButton)){
            driverTools.clickElement(closePopupButton);
        }
    }
}
