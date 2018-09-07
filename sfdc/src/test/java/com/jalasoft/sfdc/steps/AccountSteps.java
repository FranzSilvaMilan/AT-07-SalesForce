package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.account.AccountEnum;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

public class AccountSteps {
    HomePage homePage;
    AppLauncher appLauncher;
    //AccountFormPage accountFormPage;
    @Given("^I go to \"([^\"]*)\" Home Page$")
    public void iGoToHomePage(String arg0) throws Throwable {
        homePage = PageFactory.getHomePage();
        appLauncher=homePage.topMenu.gotToAppLaucher();
        //accountFormPage=appLauncher.gotToAccountPage();

    }

    @And("^I click on New \"([^\"]*)\"$")
    public void iClickOnNew(String arg0) throws Throwable {
        //accountFormPage.clickSaveNewButton();
    }

    /**@When("^I fill the Account form with:$")
    public void iFillTheAccountFormWith(final Map<AccountEnum, String> values) throws Throwable {
        values.keySet().forEach(step -> accountFormPage.getStrategyStepMap(values).get(step).fillField());
        //accountFormPage.clickSaveNewButton();
    }*/
}
