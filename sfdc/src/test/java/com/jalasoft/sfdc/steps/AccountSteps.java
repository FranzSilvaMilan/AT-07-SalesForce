package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailsPage;
import com.jalasoft.sfdc.ui.pages.account.AccountEnum;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * class account steps
 */
public class AccountSteps {
    private HomePage homePage;
    private AppLauncher appLauncher;
    private AccountFormPage accountFormPage;
    private AccountListPage accountListPage;
    private AccountDetailsPage accountDetailPage;

    //****************************************************************
    //Account Step Definitions
    //****************************************************************

    /**
     * Navigate to Account list page.
     */
    @Given("^I go to Account Home Page$")
    public void iGoToAccountPage() {
        homePage = PageFactory.getHomePage();
        appLauncher = homePage.topMenu.gotToAppLauncher();
        accountListPage = appLauncher.gotToAccountPage();

    }

    /**
     * click on new Button
     */
    @And("^I click on New Account$")
    public void iClickOnNew() {
        accountFormPage = accountListPage.clickNewButton();
    }

    /**
     * fill field with
     *
     * @param values that need for fill
     */
    @When("^I fill the Account form with:$")
    public void iFillTheAccountFormWith(final Map<AccountEnum, String> values) {
        values.keySet().forEach(step -> accountFormPage.getStrategyStepMap(values).get(step).fillField());
        accountDetailPage = accountFormPage.clickSaveButton();
    }

    /**
     * fill with field requiered
     *
     * @param nameRequeried on form of create account
     */
    @When("^I fill the Account form name with : \"([^\"]*)\"$")
    public void iFillTheAccountFormNameWith(String nameRequeried) {
        accountDetailPage = accountFormPage.setRequeredFiel(nameRequeried);
    }

    /**
     * verify that name is displayed
     *
     * @param nameAccount for verify
     */
    @Then("^\"([^\"]*)\" name should be displayed in detail Page Account$")
    public void nameShouldBeDisplayedInDetailPageAccount(String nameAccount) {
        String nameNewAccount = accountDetailPage.getNameNewAccount();
        assertEquals(nameNewAccount, nameAccount);
    }
}
