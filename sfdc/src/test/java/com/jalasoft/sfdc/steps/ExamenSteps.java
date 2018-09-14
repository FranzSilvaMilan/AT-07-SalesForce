package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.products.ProductDetailsPage;
import com.jalasoft.sfdc.ui.pages.products.ProductFormPage;
import com.jalasoft.sfdc.ui.pages.products.ProductListPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ExamenSteps {

    private ProductFormPage productFormPage;
    private ProductListPage productListPage;
    private ProductDetailsPage productDetailsPage;
    private HomePage homePage;

    private  Product product1;

    @When("^I click a edit Product$")
    public void iClickAEditProduct() {
        homePage = PageFactory.getHomePage();
        productDetailsPage=PageFactory.getProductDetailsPage();
        productFormPage = productDetailsPage.clickEditBtn1();
    }

    @And("^I fill fields$")
    public void iFillFields(List<Product> product) {
        product1 = product.get(0);
        //productListPage = productFormPage.clickSaveEditProduct(product1);

        productDetailsPage = productFormPage.clickSaveEditProduct1(product1);
    }

    @Then("^Should be displayed list Product Page$")
    public void shouldBeDisplayedListProductPage() {
        homePage = PageFactory.getHomePage();
        productDetailsPage=PageFactory.getProductDetailsPage();
        assertEquals(productDetailsPage.validateInputs1().get(0), product1.getProductName());
        assertEquals(productDetailsPage.validateInputs1().get(1), product1.getProductCode());
    }
}
