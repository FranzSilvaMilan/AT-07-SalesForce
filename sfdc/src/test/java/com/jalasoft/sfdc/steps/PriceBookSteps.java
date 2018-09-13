package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookDetailsPage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookFormPage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookListPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

public class PriceBookSteps {
    private HomePage homePage;
    private AppLauncher appLauncher;
    private PriceBookListPage priceBookListPage;
    private PriceBookFormPage priceBookFormPage;
    private PriceBookDetailsPage priceBookDetails;

    @When("^I go to PriceBook list Page$")
    public void iGoToPriceBookListPage() {
        homePage = PageFactory.getHomePage();
        appLauncher = homePage.topMenu.gotToAppLauncher();
        priceBookListPage = appLauncher.goToPriceBookPage();
    }

    @And("^I fill in required fields \"([^\"]*)\", \"([^\"]*)\"$")
    public void iFillInRequiredFields(String title, String description) {
        priceBookFormPage = priceBookListPage.clickButtonNew();
        priceBookDetails = priceBookFormPage.clickSavePriceBook(title, description);
    }

    @Then("^Should be displayed Detail PriceBook Page with \"([^\"]*)\"$")
    public void shouldBeDisplayedDetailPriceBookPageWith(String titlePriceBook) {
        assertEquals(priceBookDetails.isPriceBookNameDisplayed(), titlePriceBook);
    }
}
