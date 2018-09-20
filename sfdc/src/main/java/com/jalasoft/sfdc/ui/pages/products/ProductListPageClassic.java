package com.jalasoft.sfdc.ui.pages.products;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Product List Page Classic class.
 *
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
     * Method for implement button new in the product home page Classic.
     * @return form create new product.
     */
    @Override
    public ProductFormPage clickButtonNew() {
        if(driverTools.isElementDisplayed(closePopupButton)){
            driverTools.clickElement(closePopupButton);
        }
        driverTools.clickElement(newButton);
        return new ProductFormPageClassic();
    }

    @Override
    public boolean validateDelete(Product product) {
        return false;
    }
}
