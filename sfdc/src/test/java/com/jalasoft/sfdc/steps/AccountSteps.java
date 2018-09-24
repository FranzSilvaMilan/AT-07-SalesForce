package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.api.apiClass.APIAccount;
import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailsPage;
import com.jalasoft.sfdc.ui.pages.account.AccountEnum;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
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
    APIAccount apiAccount;

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

    /**
     * create account
     *
     * @param accountList
     */
    @And("^I have new Account with following information:$")
    public void iHaveAccountWithFollowingInformation(List<Account> accountList) {
        account = accountList.get(0);
        iClickOnNew();
        accountDetailPage = accountFormPage.saveAccount(account);

    }

    /**
     * go to form account page
     */
    @When("^I select the Account$")
    public void iSelectTheAccount() {
        //
        accountFormPage = accountDetailPage.clickEditButton();
    }

    /**
     * edit account with following information
     *
     * @param accountListEdit values for edit
     */
    @And("^I edit the Account with the following information:$")
    public void iEditThatAccountWithTheFollowingInformation(List<Account> accountListEdit) {
        //accountListEdit.forEach(step -> accountFormPage.);
        accountEdit = accountListEdit.get(0);
        System.out.println(accountEdit.getName() + " "+ accountEdit.getNumber());
        accountDetailPage = accountFormPage.saveAccount(accountEdit);

    }

    /**
     * validate account that is showed on details page
     *
     * @param nameSaved
     */
    @Then("^I should see the Account updated in the Accounts page \"([^\"]*)\"$")
    public void iShouldSeeTheAccountUpdatedInTheAccountsPage(String nameSaved) {
        assertEquals(accountDetailPage.getNameNewAccount(), nameSaved);
        //validateAccount(account);
    }

    /**
     * delete account for UI
     */
    @And("^I delete the Account$")
    public void iDeleteTheAccount() {
        accountListPage = accountDetailPage.clickDelitButton();
    }

    /**
     * verificate that account is deleted
     */
    @Then("^I should see the Account is removed from the Accounts list page$")
    public void iShouldSeeTheAccountIsRemovedFromTheAccountsListPage() {
        assertFalse(accountListPage.containTheAccount(account));
    }

    /**
     * validate all field on sales force UI
     *
     * @param myAccount
     */
    private void validateAccount(Account myAccount) {
        assertTrue(accountDetailPage.containsThisElement(myAccount.getName()), "The Name was not displayed correctly");
        assertTrue(accountDetailPage.containsThisElement(myAccount.getFax()), "The Description was not displayed correctly");
        assertTrue(accountDetailPage.containsThisElement(myAccount.getEmployees()), "The Employees was not displayed correctly");
        assertTrue(accountDetailPage.containsThisElement(myAccount.getPhone()), "The Phone was not displayed correctly");
        assertTrue(accountDetailPage.containsThisElement(myAccount.getNumber()), "The Indutry was not displayed correctly");
        assertTrue(accountDetailPage.containsThisElement(myAccount.getSicCode()), "The Type was not displayed correctly");
        assertTrue(accountDetailPage.containsThisElement(myAccount.getWeb()), "The Web adrres was not displayed correctly");
    }

    /**
     * create account with API
     *
     * @param accountList
     */
    @And("^I have Account with following information:$")
    public void iCreateByAPINewAccountWithFollowingInformation(List<Account> accountList) {
        apiAccount = new APIAccount(accountList.get(0));
        account = accountList.get(0);
        apiAccount.createSObjectRecord();
    }

    /**
     * veifify account with API
     */
    @Then("^name should be displayed in detail Page Account$")
    public void nameShouldBeDisplayedInDetailPageAccount() {
        Account accountSpected = apiAccount.getAccountValuesByAPI();
        assertEquals(accountSpected.getName(), account.getName());
    }

    /**
     * the account list 
     */
    @When("^I select the Account on list account page$")
    public void iSelectTheAccountOnListAccountPage() {
        accountDetailPage = accountListPage.clickAccountOnList(account);
        accountFormPage = accountDetailPage.clickEditButton();
    }

    /**
     * verify that account is update
     */
    @Then("^I should the Account updated$")
    public void iShouldTheAccountUpdated() {
        Account accountSpected = apiAccount.getAccountValuesByAPI();
        assertEquals(accountSpected.getName(), accountEdit.getName());
        assertEquals(accountSpected.getWeb(), accountEdit.getWeb());
    }

    //****************************************************************
    //Hooks for @create Account api scenarios
    //****************************************************************
    @After(value = "@deleteAccountAfter", order = 999)
    public void afterLoginScenario() {
        apiAccount.deleteSObjectRecord();
    }
}
