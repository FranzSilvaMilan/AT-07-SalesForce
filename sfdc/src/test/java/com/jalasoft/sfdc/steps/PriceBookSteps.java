package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookFormPage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;

public class PriceBookSteps {
    private HomePage homePage;
    private AppLauncher appLauncher;
    private PriceBookPage priceBookPage;
    private PriceBookFormPage priceBookFormPage;

    @When("^I click in the option Price Book$")
    public void iClickInTheOptionPriceBook() throws Throwable {
        homePage = PageFactory.getHomePage();
        appLauncher = homePage.topMenu.gotToAppLaucher();
        priceBookPage = appLauncher.gotToPriceBookPage();
    }

    @When("^I click on button New$")
    public void iClickOnButtonNew(){
        priceBookFormPage = priceBookPage.clickButtonNew();
    }
}
