package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookCreatedPage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookFormPage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookListPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PriceBookSteps {
    private HomePage homePage;
    private AppLauncher appLauncher;
    private PriceBookFormPage priceBookFormPage;
    private PriceBookListPage priceBookListPage;
    private PriceBookCreatedPage priceBookCreatedPage;

    @When("^I click in the option Price Book$")
    public void iClickInTheOptionPriceBook() {
        homePage = PageFactory.getHomePage();
        appLauncher = homePage.topMenu.gotToAppLaucher();
        priceBookFormPage = appLauncher.gotToPriceBookPage();

    }

    @When("^I click in New button$")
    public void iClickInNewButton() {
        priceBookListPage = priceBookFormPage.clickNewButton();
    }

    @When("^Fill the empty fields \"([^\"]*)\", \"([^\"]*)\" and put active \"([^\"]*)\"$")
    public void fillTheEmptyFieldsAndPutActive(String title, String description, boolean active) {
        if (active == true) {
            priceBookCreatedPage = priceBookListPage.getClickSavePriceBook(title, description);
            //priceBookCreatedPage = priceBookListPage.clickSavePriceBook();
        }
    }

    @Then("^Create a new Price Book$")
    public void createANewPriceBook() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
