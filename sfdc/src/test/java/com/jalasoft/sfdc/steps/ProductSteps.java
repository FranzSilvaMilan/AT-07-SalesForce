package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.api.apiClass.APIProduct;
import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.products.ProductDetailsPage;
import com.jalasoft.sfdc.ui.pages.products.ProductFormPage;
import com.jalasoft.sfdc.ui.pages.products.ProductListPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertSame;

/**
 * Products steps class.
 *
 * @author Erik Vargas.
 */
public class ProductSteps {
    // Pages
    private HomePage homePage;
    private AppLauncher appLauncher;
    private ProductListPage productListPage;
    private ProductFormPage productFormPage;
    private ProductDetailsPage productDetailsPage;
    // Entities
    private Product product1;

    APIProduct apiProduct;

    //****************************************************************
    //Product Step Definitions
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
    @And("^I click a New Product button$")
    public void iClickANewProduct() {
        productFormPage = productListPage.clickButtonNew();
    }

    /**
     * Fill required fields.
     * @param product - Name of the Product.
     */
    @When("^I create the Product with the following information$")
    public void iFillInRequiredFields(List<Product> product) {
        product1 = product.get(0);
        productDetailsPage = productFormPage.clickSaveProduct(product1);
    }

    /**
     * Validation of the product created.
     */
    @Then("^the Product information should be displayed in Product Details page$")
    public void shouldBeDisplayedDetailProductPageWith() {
        assertEquals(productDetailsPage.isProductNameDisplayed(), product1.getProductName());
        assertEquals(productDetailsPage.validateInputs().get(0), product1.getProductName());
        assertEquals(productDetailsPage.validateInputs().get(1), product1.getProductCode());
        assertEquals(productDetailsPage.validateInputs().get(2),product1.getProductDescription());
        assertEquals(productDetailsPage.validateInputs().get(3),product1.getProductFamily());
        assertEquals(productDetailsPage.validateCheckBox(),product1.getActive());
    }

    /**
     * Delete Product.
     */
    @And("^I click on Delete Product button$")
    public void iClickDeleteProduct() {
        productDetailsPage.clickDeleteButton();
    }

    /**
     * Validation of the product deleted.
     */
    @Then("^The removed product should not be shown in the list$")
    public void theRemovedProductShouldNotBeShownInTheList() {
        assertFalse(productDetailsPage.validateDelete(product1));
        assertFalse(productListPage.validateDelete(product1));
    }

    //*******************************************************
    // create product with API
    //*******************************************************

    /**
     * Create product with API.
     * @param productList fields.
     */
    @Given("^I create by API new Product with following information:$")
    public void iCreateByAPINewProductWithFollowingInformation(List<Product> productList) {
        product1 = productList.get(0);
        apiProduct = new APIProduct(product1);
        apiProduct.createSObjectRecord();
    }

    /**
     * verify that product created with API.
     */
    @And("^the Product should be created$")
    public void nameShouldBeDisplayedInDetailPageProduct() {
        assertEquals(apiProduct.getProductValuesByAPI().getProductName(),product1.getProductName());
        assertEquals(apiProduct.getProductValuesByAPI().getProductCode(),product1.getProductCode());
        assertEquals(apiProduct.getProductValuesByAPI().getProductDescription(),product1.getProductDescription());
        assertEquals(apiProduct.getProductValuesByAPI().getProductFamily(),product1.getProductFamily());
        assertEquals(apiProduct.getProductValuesByAPI().getActive(),product1.getActive());
    }

    /**
     * select product of the Product list page.
     */
    @And("^I select the Product in Product list page$")
    public void iSelectTheProductInProductListPage() {
        productDetailsPage = productListPage.clickProductOnList(product1);
    }

    /**
     * click on edit button.
     */
    @And("^I click on Edit Product button$")
    public void iClickOnEditProductButton() {
        homePage = PageFactory.getHomePage();
        productDetailsPage=PageFactory.getProductDetailsPage();
        productFormPage = productDetailsPage.clickEditBtn();
    }
    /**
     * Edit product since product list page.
     */
    @And("^I edited Product with following information:$")
    public void iEditedProductWithFollowingInformation(List<Product> productList) {
        product1 = productList.get(0);
        productDetailsPage = productFormPage.clickSaveEditProduct(product1);
    }

    /**
     *
     * @param priceStandard
     */
    @And("^I add Standard Price to Product with \"([^\"]*)\"$")
    public void iAddStandardPriceToProductWith(String priceStandard) {
        productDetailsPage = productDetailsPage.clickAddPriceStandard(priceStandard);
    }

    /**
     *
     * @param priceBook
     */
    @And("^I add the Product to Price Book Standard with List Price \"([^\"]*)\"$")
    public void iAddTheProductToPriceBookStandardWithListPrice(String priceBook) {
        productDetailsPage = productDetailsPage.clickAddPriceBook(priceBook);
    }

    //****************************************************************
    //Hooks for @delete Product api scenarios
    //****************************************************************
    @After(value = "@deleteProductAfter", order = 999)
    public void afterLoginScenario() {
        apiProduct.deleteSObjectRecord();
    }

}
