package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.api.apiClass.APIAccount;
import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.entities.AllEntities;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailsPage;
import com.jalasoft.sfdc.ui.pages.account.AccountEnum;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.StrategySetInputs;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * class account steps
 */
public class AccountSteps {
    private Logger log = Logger.getLogger(getClass());
    private HomePage homePage;
    private AppLauncher appLauncher;
    private AccountFormPage accountFormPage;
    private AccountListPage accountListPage;
    private AccountDetailsPage accountDetailPage;
    private Account account;
    private Account accountEdit;
    private APIAccount apiAccount;
    private AllEntities allEntities;
    public AccountSteps(AllEntities allSteps){
       allEntities = allSteps;
    }
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
    public void iFillTheAccountFormWith(final DataTable values) {
        account= values.transpose().asList(Account.class).get(0);
        apiAccount = new APIAccount(account);
        Map<AccountEnum,StrategySetInputs> strategyMap =accountFormPage.getStrategyStepMap(values.asMap(AccountEnum.class,String.class));
        values.asMap(AccountEnum.class,String.class).keySet().forEach(step -> strategyMap.get(step).fillField());
        accountDetailPage = accountFormPage.clickSaveButton();
        accountDetailPage.getIdAccount(account);
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
        account.updateAccountName();
        iClickOnNew();
        apiAccount = new APIAccount(account);
        //accountFormPage.saveAccount(account).forEach(input -> input.fillField());
        accountFormPage.saveAccount(account).stream().filter(input -> {
            try {
                input.fillField();
                return  true;
            } catch (Exception e) {
                return false;
            }
        }).forEach(StrategySetInputs::fillField);

        accountDetailPage = accountFormPage.clickSaveButton();
        accountDetailPage.getIdAccount(account);

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
        accountEdit = accountListEdit.get(0);
        accountEdit.updateAccountName();
        accountFormPage.saveAccount(accountEdit).forEach(StrategySetInputs::fillField);
       accountDetailPage=accountFormPage.clickSaveButton();
    }

    /**
     * validate account that is showed on details page
     */
    @Then("^I should see the Account updated in the Accounts page$")
    public void iShouldSeeTheAccountUpdatedInTheAccountsPage() {
        assertEquals(accountDetailPage.getNameNewAccount(), accountEdit.getName());
        validateAccount(accountEdit);
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
        //assertTrue(accountDetailPage.containsThisElement(myAccount.getFax()), "The Accunt was not displayed correctly");
        //assertTrue(accountDetailPage.containsThisElement(myAccount.getEmployees()), "The Employees was not displayed correctly");
        //assertTrue(accountDetailPage.containsThisElement(myAccount.getPhone()), "The Phone was not displayed correctly");
        assertTrue(accountDetailPage.containsThisElement(myAccount.getNumber()), "The number was not displayed correctly");
        //assertTrue(accountDetailPage.containsThisElement(myAccount.getSicCode()), "The Sic was not displayed correctly");
        assertTrue(accountDetailPage.containsThisElement(myAccount.getWeb()), "The Web was not displayed correctly");
    }

    /**
     * create account with API
     *
     * @param accountList
     */
    @And("^I have Account with following information:$")
    public void iCreateByAPINewAccountWithFollowingInformation(List<Account> accountList) {
        account = accountList.get(0);
        account.updateAccountName();
        apiAccount = new APIAccount(account);
        apiAccount.createSObjectRecord();
        allEntities.setAccount(account);

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

    @And("^I click on Edit Button$")
    public void iClickOnEditButton() {
        accountFormPage = accountDetailPage.clickEditButton();
    }

    //****************************************************************
    //Hooks for @create Account api scenarios
    //****************************************************************
    @After(value = "@deleteAccountAfter", order = 999)
    public void afterAccountScenario() {
        apiAccount.deleteSObjectRecord();
    }


}
