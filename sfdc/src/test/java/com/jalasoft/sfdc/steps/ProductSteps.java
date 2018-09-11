package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.products.ProductDetails;
import com.jalasoft.sfdc.ui.pages.products.ProductFormPage;
import com.jalasoft.sfdc.ui.pages.products.ProductListPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static org.testng.Assert.assertEquals;

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
     * Fill required fields.
     * @param name - Name of the Product.
     */
    @And("^I fill in required fields \"([^\"]*)\"$")
    public void iFillInRequiredFields(String name) {
        productFormPage = productListPage.clickButtonNew();
        productDetails = productFormPage.clickSaveProduct(name);
    }

    /**
     * Validation of the product created.
     * @param name - Name of the project created.
     */
    @Then("^Should be displayed Detail Product Page with \"([^\"]*)\"$")
    public void shouldBeDisplayedDetailProductPageWith(String name) {
        assertEquals(productDetails.isProductNameDisplayed(), name);
    }
}
