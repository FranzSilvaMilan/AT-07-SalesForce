package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.api.apiClass.APIProduct;
import com.jalasoft.sfdc.entities.AllEntities;
import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.products.ProductDetailsPage;
import com.jalasoft.sfdc.ui.pages.products.ProductFormPage;
import com.jalasoft.sfdc.ui.pages.products.ProductListPage;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

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
    private AllEntities allEntities;

    APIProduct apiProduct;
    public ProductSteps(AllEntities allEntities){
        this.allEntities = allEntities;
    }
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
    @When("^I have a Product with the following information:$")
    public void iFillInRequiredFields(final List<Product> product) {
        product1 = product.get(0);
        product1.updateProductName();
        apiProduct = new APIProduct(product1);
        allEntities.setProduct(product1);
        productDetailsPage = productFormPage.clickSaveProduct(product1);
        productDetailsPage.getIdProduct(product1);
    }

    /**
     * Validation of the product created ui.
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
    @Given("^I have a Product with the following information$")
    public void iCreateByAPINewProductWithFollowingInformation(final List<Product> productList) {
        product1 = productList.get(0);
        product1.updateProductName();
        allEntities.setProduct(product1);
        apiProduct = new APIProduct(product1);
        apiProduct.createSObjectRecord();
    }

    /**
     * verify that product created with API.
     */
    @And("^the Product should be created$")
    public void nameShouldBeDisplayedInDetailPageProduct() {
        Product productExpected =apiProduct.getProductValuesByAPI();
        assertEquals(productExpected.getProductName(),product1.getProductName());
        assertEquals(productExpected.getProductCode(),product1.getProductCode());
        assertEquals(productExpected.getProductDescription(),product1.getProductDescription());
        assertEquals(productExpected.getProductFamily(),product1.getProductFamily());
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
    public void iEditedProductWithFollowingInformation(final List<Product> productList) {
        product1 = productList.get(0);
        productDetailsPage = productFormPage.clickSaveEditProduct(product1);
    }

    /**
     * add price standard to Product.
     * @param priceStandard field.
     */
    @And("^I add Standard Price to Product with \"([^\"]*)\"$")
    public void iAddStandardPriceToProductWith(String priceStandard) {
        productDetailsPage = productDetailsPage.clickAddPriceStandard(priceStandard);
    }

    /**
     * add price book to Product.
     * @param priceBook field.
     */
    @And("^I add the Product to Price Book Standard with List Price \"([^\"]*)\"$")
    public void iAddTheProductToPriceBookStandardWithListPrice(String priceBook) {
        product1.setPriceBook(priceBook);
        productDetailsPage = productDetailsPage.clickAddPriceBook(priceBook);
    }

    //****************************************************************
    //Hooks for @delete Product api scenarios
    //****************************************************************
    @After(value = "@deleteProduct", order = 999)
    public void afterProductScenario() {
        apiProduct.deleteSObjectRecord();
    }
}
