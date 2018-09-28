package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.api.apiClass.APIProduct;
import com.jalasoft.sfdc.entities.AllEntities;
import com.jalasoft.sfdc.entities.Opportunitie;
import com.jalasoft.sfdc.entities.Product;
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
    private APIProduct productAPI;
    private AllEntities allEntities;

    public OpportunitySteps(AllEntities allEntities){
        this.allEntities = allEntities;
    }

    /**
     * We will go to the start page of the Classic or Light for add Opportunities.
     */
    @When("^I go to Opportunities list Page$")
    public void iGoToOpportunitiesListPage() {
        homePage = PageFactory.getHomePage();
        appLauncher = homePage.topMenu.gotToAppLauncher();
        opportunitieListPage = appLauncher.goToOpportunitiesPage();
    }

    /**
     * You to have click on the New button.
     */
    @And("^I click on New Opportunity button$")
    public void iClickOnNewOpportunitie() {
        opportunitieFormPage = opportunitieListPage.gotToNewButton();
    }

    /**
     * We will make an insertion of data to the class Opportunities.
     * @param opportunities - class object Opportunities.
     */
    @When("^I created an Opportunity with the following information$")
    public void iCreatedAnOpportunityWithTheFollowingInformation(List<Opportunitie> opportunities) {
        this.opportunitie = opportunities.get(0);
        opportunitie.setAccountName(allEntities.getAccount().getName());
        opportunitieDetailsPage = opportunitieFormPage.gotToSaveButton(opportunitie);
    }

    /**
     * It is verified if the name of the Opportunity created is displayed.
     */
    @Then("^the Opportunity should be displayed in details page$")
    public void theOpportunityShouldBeDisplayedInDetailsPage() {
        assertTrue(opportunitieDetailsPage.isChangeDisplayed(opportunitie));
    }

    /**
     * A new Quote will be created from an Opportunity created with the input data.
     * @param quotes - class object Quotes
     */
    @When("^I create a new Quote with following information$")
    public void iCreateANewQuoteWithName(List<Quote> quotes) {
        this.quote = quotes.get(0);
        quotesFormPage = opportunitieDetailsPage.isNewQuoteSelect();
        quotesDetailsPage = quotesFormPage.gotToSaveButton(quote);
        quotesAddProductPage = quotesDetailsPage.addProduct();
        quoteItemPage = quotesAddProductPage.isSelectOptionButton(allEntities.getProduct().getProductName());
    }

    /**
     * The quantity and the standard price will be added to our created Quotes.
     * @param quotes - class object Quotes.
     */
    @And("^I add the following line items$")
    public void iAddTheFollowingLineItems(List<Quote> quotes) {
        this.quote.setPrice(quotes.get(0).getPrice());
        this.quote.setQuantity(quotes.get(0).getQuantity());
        quotesDetailsPage = quoteItemPage.isClickSaveItemButton(quote);
    }

    @Then("^the Quotes should be displayed in details page$")
    public void theQuotesShouldBeDisplayedInDetailsPage(){
        //Product productSpected = productAPI.getProductValuesByAPI();
        assertTrue(quotesDetailsPage.validateQuotesAndProduct(allEntities.getProduct().getPriceBook(),
                quote.getQuantity()));

    }
}
