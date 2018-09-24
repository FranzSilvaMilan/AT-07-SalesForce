package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.EnumMap;
import java.util.Map;

public class AccountFormPageLight extends AccountFormPage {

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }

    @FindBy(css = ".witsSuggestedNameField .input")
    private WebElement accountNameTextField;
    @FindBy(css = "input[title='Search Accounts']")
    private WebElement parentAccountTextField;
    @FindBy(xpath =
            "//span[text()='Account Number']/parent::label/following-sibling::input")
    private WebElement accountNumberTextField;

    @FindBy(xpath =
            "//span[text()='Account Site']/parent::label/following-sibling::input")
    private WebElement accountSiteTextField;
    @FindBy(xpath =
            "//span[text()='Type']/parent::span/following-sibling::div/descendant::a")
    private WebElement typeList;
    @FindBy(xpath =
            "//span[text()='Industry']/parent::span/following-sibling::div/descendant::a")
    private WebElement industryList;
    @FindBy(xpath =
            "//span[text()='Annual Revenue']/parent::label/following-sibling::input")
    private WebElement annualRevenueTextField;
    @FindBy(xpath =
            "//span[text()='Rating']/parent::span/following-sibling::div/descendant::a")
    private WebElement ratingList;
    @FindBy(xpath =
            "//span[text()='Phone']/parent::label/following-sibling::input")
    private WebElement accountPhone;
    @FindBy(xpath =
            "//span[text()='Fax']/parent::label/following-sibling::input")
    private WebElement accountFax;
    @FindBy(xpath =
            "//span[text()='Website']/parent::label/following-sibling::input")
    private WebElement accountWebsite;
    @FindBy(xpath =
            "//span[text()='Ticker Symbol']/parent::label/following-sibling::input")
    private WebElement accountTickerSymbol;
    @FindBy(xpath =
            "//span[text()='Ownership']/parent::span/following-sibling::div/descendant::a")
    private WebElement ownershipList;
    @FindBy(xpath =
            "//span[text()='Employees']/parent::label/following-sibling::input")
    private WebElement accountEmployee;
    @FindBy(xpath =
            "//span[text()='SIC Code']/parent::label/following-sibling::input")
    private WebElement accountSICCode;


    //-----------------------------------------------------------------------------------------------------------------

    /**
     * set accountEmployee attribute.
     *
     * @param accountSICCode string value.
     */
    public void setAccountSICCodeTextField(final String accountSICCode) {
        driverTools.setInputField(this.accountSICCode, accountSICCode);
    }

    /**
     * set accountEmployee attribute.
     *
     * @param accountEmployee string value.
     */
    public void setAccountEmployeeTextField(final String accountEmployee) {
        driverTools.setInputField(this.accountEmployee, accountEmployee);
    }

    /**
     * set accountOwnershipList attribute.
     *
     * @param accountOwnershipList string value.
     */
    public void setAccountOwnershipList(final String accountOwnershipList) {
    }

    /**
     * set accountTickerSymbol attribute.
     *
     * @param accountTickerSymbol string value.
     */
    public void setAccountTickerSymbolTextField(final String accountTickerSymbol) {
        driverTools.setInputField(this.accountTickerSymbol, accountTickerSymbol);
    }

    /**
     * set accountWebsite attribute.
     *
     * @param accountWebsite string value.
     */
    public void setAccountWebsiteTextField(final String accountWebsite) {
        driverTools.setInputField(this.accountWebsite, accountWebsite);
    }

    /**
     * set accountPhone attribute.
     *
     * @param accountFax string value.
     */
    public void setAccountFaxTextField(final String accountFax) {
        driverTools.setInputField(this.accountFax, accountFax);
    }

    /**
     * set accountPhone attribute.
     *
     * @param accountPhone string value.
     */
    public void setAccountPhoneTextField(final String accountPhone) {
        driverTools.setInputField(this.accountPhone, accountPhone);
    }

    /**
     * set ratingList attribute.
     *
     * @param ratingList string value.
     */
    public void setAccountRatingList(final String ratingList) {
    }

    /**
     * set accountName attribute.
     *
     * @param accountName string value.
     */
    private void setAccountNameTextField(final String accountName) {
        driverTools.setInputField(this.accountNameTextField, accountName);
    }

    /**
     * set parentAccount attribute.
     *
     * @param parentAccount the value.
     */
    private void setParentAccountTextField(final String parentAccount) {
        driverTools.setInputField(this.parentAccountTextField, parentAccount);
    }

    /**
     * set accountNumber attribute.
     *
     * @param accountNumber the value.
     */
    private void setAccountNumberTextField(final String accountNumber) {
        driverTools.setInputField(this.accountNumberTextField, accountNumber);
    }

    /**
     * set accountSite attribute.
     *
     * @param accountSite the value.
     */
    private void setAccountSiteTextField(final String accountSite) {
        driverTools.setInputField(this.accountSiteTextField, accountSite);
    }

    /**
     * Method to set type attribute.
     *
     * @param type the value.
     */
    private void setAccountTypeList(final String type) {
    }

    /**
     * set industry attribute.
     *
     * @param industry the value.
     */
    private void setIndustryList(final String industry) {
    }

    /**
     * set annualRevenue attribute.
     *
     * @param annualRevenue the value.
     */
    private void setAnnualRevenueTextField(final String annualRevenue) {

    }

    /**
     * set field requiered on form account.
     *
     * @param value requiered
     * @return page with detail.
     */
    public AccountDetailsPage setRequeredFiel(String value) {
        setAccountNameTextField(value);
        driverTools.clickElement(saveButton);
        return PageFactory.getDetailAccountPage();
    }

    /**
     * @param values account fields.
     * @return map of account fields.
     */
    @Override
    public Map<AccountEnum, StrategySetInputs> getStrategyStepMap(final Map<AccountEnum, String> values) {
        EnumMap<AccountEnum, StrategySetInputs> strategyMap = new EnumMap<>(AccountEnum.class);

        strategyMap.put(AccountEnum.ACCOUNT_NAME, () ->
                this.setAccountNameTextField(String.valueOf(values.get(AccountEnum.ACCOUNT_NAME))));

        strategyMap.put(AccountEnum.ACCOUNT_NUMBER, () ->
                this.setAccountNumberTextField(String.valueOf(values.get(AccountEnum.ACCOUNT_NUMBER))));

        strategyMap.put(AccountEnum.ACCOUNT_SITE, () ->
                this.setAccountSiteTextField(String.valueOf(values.get(AccountEnum.ACCOUNT_SITE))));

        strategyMap.put(AccountEnum.ANNUAL_REVENUE, () ->
                this.setAnnualRevenueTextField(String.valueOf(values.get(AccountEnum.ANNUAL_REVENUE))));

        strategyMap.put(AccountEnum.INDUSTRY, () ->
                this.setIndustryList(String.valueOf(values.get(AccountEnum.INDUSTRY))));

        strategyMap.put(AccountEnum.PARENT_ACCOUNT, () ->
                this.setParentAccountTextField(String.valueOf(values.get(AccountEnum.PARENT_ACCOUNT))));

        strategyMap.put(AccountEnum.TYPE, () ->
                this.setAccountTypeList(String.valueOf(values.get(AccountEnum.TYPE))));

        strategyMap.put(AccountEnum.RATING, () ->
                this.setAccountRatingList(String.valueOf(values.get(AccountEnum.RATING))));

        strategyMap.put(AccountEnum.PHONE, () ->
                this.setAccountPhoneTextField(String.valueOf(values.get(AccountEnum.PHONE))));

        strategyMap.put(AccountEnum.FAX, () ->
                this.setAccountFaxTextField(String.valueOf(values.get(AccountEnum.FAX))));

        strategyMap.put(AccountEnum.WEBSITE, () ->
                this.setAccountWebsiteTextField(String.valueOf(values.get(AccountEnum.WEBSITE))));

        strategyMap.put(AccountEnum.TICKER_SYMBOL, () ->
                this.setAccountTickerSymbolTextField(String.valueOf(values.get(AccountEnum.TICKER_SYMBOL))));

        strategyMap.put(AccountEnum.OWNERSHIP, () ->
                this.setAccountOwnershipList(String.valueOf(values.get(AccountEnum.OWNERSHIP))));

        strategyMap.put(AccountEnum.EMPLOYEES, () ->
                this.setAccountEmployeeTextField(String.valueOf(values.get(AccountEnum.EMPLOYEES))));

        strategyMap.put(AccountEnum.SIC_CODE, () ->
                this.setAccountSICCodeTextField(String.valueOf(values.get(AccountEnum.SIC_CODE))));
        return strategyMap;
    }

    /**
     * set field requiered on form account.
     *
     * @return page with detail.
     */
    @Override
    public AccountDetailsPage clickSaveButton() {

        driverTools.clickElement(saveButton);
        return PageFactory.getDetailAccountPage();
    }
    @Override
    public AccountDetailsPage saveAccount(Account account) {
        if (account.getName() != null) driverTools.setInputField(accountNameTextField, account.getName());
        if (account.getNumber() != null) driverTools.setInputField(accountNumberTextField, account.getNumber());
        if (account.getWeb() != null) driverTools.setInputField(accountWebsite, account.getWeb());
        if (account.getFax() != null) driverTools.setInputField(accountFax, account.getFax());
        if (account.getPhone() != null) driverTools.setInputField(accountPhone, account.getPhone());
        if (account.getSicCode() != null) driverTools.setInputField(accountSICCode, account.getSicCode());
        if (account.getEmployees() != null) driverTools.setInputField(accountEmployee, account.getEmployees());
        driverTools.clickElement(saveButton);
        driverTools.sleepMilliSeconds(3000);
        return new AccountDetailsPageLight();
    }
}
