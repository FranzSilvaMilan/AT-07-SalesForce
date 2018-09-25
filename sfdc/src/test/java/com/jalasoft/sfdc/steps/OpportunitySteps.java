package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.Opportunitie;
import com.jalasoft.sfdc.entities.Quote;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitieDetailsPage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitieFormPage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitieListPage;
import com.jalasoft.sfdc.ui.pages.quote.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertTrue;

import java.util.List;

public class OpportunitySteps {
    private HomePage homePage;
    private AppLauncher appLauncher;

    private Opportunitie opportunitie;
    private OpportunitieDetailsPage opportunitieDetailsPage;
    private OpportunitieFormPage opportunitieFormPage;
    private OpportunitieListPage opportunitieListPage;
    private QuotesFormPage quotesFormPage;
    private QuotesDetailsPage quotesDetailsPage;
    private QuotesAddProductPage quotesAddProductPage;
    private QuoteItemPage quoteItemPage;

    private Quote quote;

    @When("^I go to Opportunitie List Page$")
    public void iGoToOpportunitieListPage(){
        homePage = PageFactory.getHomePage();
        appLauncher = homePage.topMenu.gotToAppLauncher();
        opportunitieListPage = appLauncher.goToOpportunitiesPage();
    }

    @And("^I click on New Opportunitie$")
    public void iClickOnNewOpportunitie() {
        opportunitieFormPage=opportunitieListPage.gotToNewButton();
    }

    @When("^I created opportunity with the following information$")
    public void iCreatedOpportunityWithTheFollowingInformation(List<Opportunitie> opportunities) {
        this.opportunitie = opportunities.get(0);
        opportunitieDetailsPage = opportunitieFormPage.gotToSaveButton(opportunitie);
    }


    @Then("^The opportunity should be displayed in details page$")
    public void theOpportunityShouldBeDisplayedInDetailsPage() {
        assertTrue(opportunitieDetailsPage.isChangeDisplayed(opportunitie));
    }


    @When("^I create a new Quote with \"([^\"]*)\" Name$")
    public void iCreateANewQuoteWithName(String test) {
        quotesFormPage=opportunitieDetailsPage.isNewQuoteSelect();
        quotesDetailsPage = quotesFormPage.gotToSaveButton(test);
        quotesAddProductPage = quotesDetailsPage.addProduct();
        quoteItemPage = quotesAddProductPage.isSelectOptionButton();
    }

    @And("^The following line item$")
    public void theFollowingLineItem(List<Quote> quotes) {
        this.quote = quotes.get(0);
        quotesDetailsPage = quoteItemPage.isClickSaveItemButton(quote);
    }
}
