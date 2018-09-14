package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.products.ProductDetails;
import com.jalasoft.sfdc.ui.pages.products.ProductFormPage;
import com.jalasoft.sfdc.ui.pages.products.ProductListPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

/**
 * Products steps class.
 *
 * @author Erik Vargas.
 */
public class ProductSteps {
    private HomePage homePage;
    private AppLauncher appLauncher;
    private ProductListPage productListPage;
    private ProductFormPage productFormPage;
    private ProductDetails productDetails;
    private Product product1;

    //****************************************************************
    //Login Step Definitions
    //****************************************************************

    /**
     * Navigate to Product list page.
     */
    @When("^I go to Product list Page$")
    public void goToProductListPage() {
        homePage = PageFactory.getHomePage();
        appLauncher = homePage.topMenu.gotToAppLauncher();
        productListPage = appLauncher.goToProductPage();
    }

    /**
     * Create new Product
     */
    @And("^I click a New Product$")
    public void iClickANewProduct() {
        productFormPage = productListPage.clickButtonNew();
    }

    /**
     * Fill required fields.
     * @param product - Name of the Product.
     */
    @And("^I fill in required fields$")
    public void iFillInRequiredFields(List<Product> product) {
        product1 = product.get(0);
        productDetails = productFormPage.clickSaveProduct(product1);
    }

    /**
     * Validation of the product created.
     */
    @Then("^Should be displayed Detail Product Page$")
    public void shouldBeDisplayedDetailProductPageWith() {
        assertEquals(productDetails.isProductNameDisplayed(), product1.getProductName());
        assertEquals(productDetails.validateInputs().get(0), product1.getProductName());
        assertEquals(productDetails.validateInputs().get(1), product1.getProductCode());
        assertEquals(productDetails.validateInputs().get(2),product1.getProductDescription());
        assertEquals(productDetails.validateInputs().get(3),product1.getProductFamily());
        assertEquals(productDetails.validateCheckBox(),product1.getActive());
    }
}
