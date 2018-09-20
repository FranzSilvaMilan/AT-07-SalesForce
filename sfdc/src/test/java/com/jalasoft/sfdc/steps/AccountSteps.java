package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailsPage;
import com.jalasoft.sfdc.ui.pages.account.AccountEnum;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * class account steps
 */
public class AccountSteps {
    private HomePage homePage;
    private AppLauncher appLauncher;
    private AccountFormPage accountFormPage;
    private AccountListPage accountListPage;
    private AccountDetailsPage accountDetailPage;
    private Account account;
    private Account accountEdit;

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
     * verify that name is displayed
     *
     * @param nameAccount for verify
     */
    @Then("^\"([^\"]*)\" name should be displayed in detail Page Account$")
    public void nameShouldBeDisplayedInDetailPageAccount(String nameAccount) {
        String nameNewAccount = accountDetailPage.getNameNewAccount();
        assertEquals(nameNewAccount, nameAccount);
    }


    @And("^I have new Account with following information:$")
    public void iHaveAccountWithFollowingInformation(List<Account> accountList) {
        account = accountList.get(0);
        iClickOnNew();
        accountDetailPage = accountFormPage.saveAccount(account);
    }

    @When("^I select the Account$")
    public void iSelectTheAccount() {
        //accountFormPage=accountDetailPage.clickAccount(account);
        accountFormPage=accountDetailPage.clickEditButton();
    }

    @And("^I edit that Account with the following information:$")
    public void iEditThatAccountWithTheFollowingInformation(List<Account> accountListEdit) {
        //accountListEdit.forEach(step -> accountFormPage.);
        accountEdit = accountListEdit.get(0);
        accountDetailPage=accountFormPage.saveAccount(accountEdit);

    }

    @Then("^I should see the Account updated in the Accounts page \"([^\"]*)\"$")
    public void iShouldSeeTheAccountUpdatedInTheAccountsPage(String nameSaved) {
        assertEquals(accountDetailPage.getNameNewAccount(),nameSaved);
    }

    @And("^I delete the Account$")
    public void iDeleteTheAccount() throws Throwable {
        accountListPage = accountDetailPage.clickDelitButton();
    }

    @Then("^I should see the Account is removed from the Accounts list page$")
    public void iShouldSeeTheAccountIsRemovedFromTheAccountsListPage() throws Throwable {
        assertFalse(accountListPage.containTheAccount(account));
    }

    private void validateAccount(Account myAccount) {
        assertTrue(accountDetailPage.containsThisElement(myAccount.getName()), "The Name was not displayed correctly");
        assertTrue(accountDetailPage.containsThisElement(myAccount.getFax()), "The Description was not displayed correctly");
        assertTrue(accountDetailPage.containsThisElement(myAccount.getEmployees()), "The Employees was not displayed correctly");
        assertTrue(accountDetailPage.containsThisElement(myAccount.getPhone()), "The Phone was not displayed correctly");
        assertTrue(accountDetailPage.containsThisElement(myAccount.getNumber()), "The Indutry was not displayed correctly");
        assertTrue(accountDetailPage.containsThisElement(myAccount.getSicCode()), "The Type was not displayed correctly");
        assertTrue(accountDetailPage.containsThisElement(myAccount.getWeb()), "The Web adrres was not displayed correctly");
    }
}
