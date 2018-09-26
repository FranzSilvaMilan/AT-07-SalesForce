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

    @When("^I go to Opportunities list Page$")
    public void iGoToOpportunitiesListPage(){
        homePage = PageFactory.getHomePage();
        appLauncher = homePage.topMenu.gotToAppLauncher();
        opportunitieListPage = appLauncher.goToOpportunitiesPage();
    }

    @And("^I click on New Opportunity button$")
    public void iClickOnNewOpportunitie() {
        opportunitieFormPage=opportunitieListPage.gotToNewButton();
    }

    @When("^I created an Opportunity with the following information$")
    public void iCreatedAnOpportunityWithTheFollowingInformation(List<Opportunitie> opportunities) {
        this.opportunitie = opportunities.get(0);
        opportunitieDetailsPage = opportunitieFormPage.gotToSaveButton(opportunitie);
    }


    @Then("^The opportunity should be displayed in details page$")
    public void theOpportunityShouldBeDisplayedInDetailsPage() {
        assertTrue(opportunitieDetailsPage.isChangeDisplayed(opportunitie));
    }


    @When("^I create a new Quote with following information$")
    public void iCreateANewQuoteWithName(List<Quote> quotes) {
        this.quote = quotes.get(0);
        quotesFormPage=opportunitieDetailsPage.isNewQuoteSelect();
        quotesDetailsPage = quotesFormPage.gotToSaveButton(quote);
        quotesAddProductPage = quotesDetailsPage.addProduct();
        quoteItemPage = quotesAddProductPage.isSelectOptionButton();
    }

    @And("^I add the following line items$")
    public void iAddTheFollowingLineItems(List<Quote> quotes) {
        this.quote.setPrice(quotes.get(0).getPrice());
        this.quote.setQuantity(quotes.get(0).getQuantity());
        quotesDetailsPage = quoteItemPage.isClickSaveItemButton(quote);
    }
}
