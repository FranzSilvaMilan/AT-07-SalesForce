package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.EnumMap;
import java.util.Map;

public class AccountFormPageClassic extends AccountFormPage {
    @Override
    public void waitUntilPageObjectIsLoaded() {
    }
    @FindBy(id = "acc2")
    private WebElement accountNameTextField;

    @FindBy(id = "acc3")
    private WebElement parentAccountTextField;

    @FindBy(id = "acc5")
    private WebElement accountNumberTextField;

    @FindBy(id = "acc23")
    private WebElement accountSiteTextField;

    @FindBy(id = "acc6")
    private WebElement typeList;

    @FindBy(id = "acc7")
    private WebElement industryList;

    @FindBy(id = "acc8")
    private WebElement annualRevenueTextField;

    @FindBy(id = "acc9")
    private WebElement ratingList;

    @FindBy(id = "acc10")
    private WebElement accountPhone;

    @FindBy(id = "acc11")
    private WebElement accountFax;

    @FindBy(id = "acc12")
    private WebElement accountWebsite;

    @FindBy(id = "acc13")
    private WebElement accountTickerSymbol;

    @FindBy(id = "acc14")
    private WebElement ownershipList;

    @FindBy(id = "acc15")
    private WebElement accountEmployee;

    @FindBy(id = "acc16")
    private WebElement accountSICCode;

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
        /**List<StrategySetInputs> strategies =
         Arrays.asList(
         () -> {setAccountNameTextField(String.valueOf(account.getName()));},
         () -> {setAccountNameTextField(String.valueOf(account.getNumber()));},
         () -> {setAccountNameTextField(String.valueOf(account.getWeb()));},
         () -> {setAccountNameTextField(String.valueOf(account.getFax()));},
         () -> {setAccountNameTextField(String.valueOf(account.getPhone()));},
         () -> {setAccountNameTextField(String.valueOf(account.getSicCode()));},
         () -> {setAccountNameTextField(String.valueOf(account.getEmployees()));}
         );
         */System.out.println("name");
        if (account.getName() != null) driverTools.setInputField(accountNameTextField, account.getName());
        System.out.println("number");
        if (account.getNumber() != null) driverTools.setInputField(accountNumberTextField, account.getNumber());
        System.out.println("web");
        if (account.getWeb() != null) driverTools.setInputField(accountWebsite, account.getWeb());
        System.out.println("fax");
        if (account.getFax() != null) driverTools.setInputField(accountFax, account.getFax());
        System.out.println("phone");
        if (account.getPhone() != null) driverTools.setInputField(accountPhone, account.getPhone());
        System.out.println("siccode");
        if (account.getSicCode() != null) driverTools.setInputField(accountSICCode, account.getSicCode());
        System.out.println("employes");
        if (account.getEmployees() != null) driverTools.setInputField(accountEmployee, account.getEmployees());
        System.out.println("click en save");
        driverTools.clickElement(saveButton);
        return PageFactory.getDetailAccountPage();
    }
}
