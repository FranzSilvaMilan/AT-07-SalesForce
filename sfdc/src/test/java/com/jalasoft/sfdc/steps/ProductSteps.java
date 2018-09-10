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
import static org.testng.Assert.assertTrue;

public class ProductSteps {
    private HomePage homePage;
    private AppLauncher appLauncher;
    private ProductListPage productHomePage;
    private ProductFormPage productFormPage;
    private ProductDetails productDetails;

    @When("^I go to Product Home Page$")
    public void iGoToHomePage() {
        homePage = PageFactory.getHomePage();
        appLauncher = homePage.topMenu.gotToAppLaucher();
        productHomePage = appLauncher.goToProductPage();
    }

    @And("^I fill in required fields \"([^\"]*)\"$")
    public void iFillInRequiredFields(String name) {
        productFormPage = productHomePage.clickButtonNew();
        productDetails = productFormPage.clickSaveProduct(name);
    }

    @Then("^Should be displayed Detail Product Page with \"([^\"]*)\"$")
    public void shouldBeDisplayedDetailProductPageWith(String name) {
        assertEquals(productDetails.isProductNameDisplayed(),name);
    }
}
