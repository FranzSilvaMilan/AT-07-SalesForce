package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.DetailPage;
import com.jalasoft.sfdc.ui.pages.ListHomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookForm;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookFormLight;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.List;

public class PriceBook {
    HomePage homePage;
    AppLauncher appLauncher;
    ListHomePage listHomePage;


    @Given("^I go to PriceBook Home Page$")
    public void iGoToPriceBookHomePage() throws Throwable {
        homePage = PageFactory.getHomePage();
        appLauncher=homePage.topMenu.gotToAppLaucher();
        listHomePage=appLauncher.gotToBookPage();
    }

    @And("^I click on New Button$")
    public void iClickOnNewButton() throws Throwable {
        listHomePage.clickSaveNewButton();
    }

    @When("^I create a New PriceBook with the following information: \"([^\"]*)\" , \"([^\"]*)\", \"([^\"]*)\"$")
    public void iCreateANewPriceBookWithTheFollowingInformation(String arg0, String arg1, String arg2) throws Throwable {
        PriceBookForm priceBookForm = PageFactory.getPagFormBook();
        DetailPage detailPage =priceBookForm.setFields(arg0,arg1,arg2);
    }
}
