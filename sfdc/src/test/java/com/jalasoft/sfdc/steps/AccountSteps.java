package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailsPage;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

public class AccountSteps {
    HomePage homePage;
    AppLauncher appLauncher;
    AccountFormPage accountFormPage;
    AccountListPage accountListPage;
    AccountDetailsPage accountDetailPage;

    @Given("^I go to Account Home Page$")
    public void iGoToHomePage(){
        homePage = PageFactory.getHomePage();
        appLauncher = homePage.topMenu.gotToAppLaucher();
        accountListPage = appLauncher.gotToAccountPage();

    }

    @And("^I click on New Account$")
    public void iClickOnNew(){
        accountFormPage = accountListPage.clickNewButton();
    }

    /**
     * @When("^I fill the Account form with:$")
     * public void iFillTheAccountFormWith(final Map<AccountEnum, String> values) throws Throwable {
     * System.out.println(values.size()+"   /////////////////////////////////////////////////////////");
     * values.keySet().forEach(step -> accountFormPage.getStrategyStepMap(values).get(step).fillField());
     * //accountFormPage.clickSaveNewButton();
     * }
     */

    @When("^I fill the Account form name with : \"([^\"]*)\"$")
    public void iFillTheAccountFormNameWith(String nameRequeried){
        accountDetailPage = accountFormPage.setRequeredFiel(nameRequeried);
    }

    @Then("^\"([^\"]*)\" name should be displayed in detail Page Account$")
    public void nameShouldBeDisplayedInDetailPageAccount(String nameAccount){
        String nameNewAccount = accountDetailPage.getNameNewAccount();
        assertEquals(nameNewAccount, nameAccount);
    }
}
