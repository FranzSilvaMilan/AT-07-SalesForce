package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class AccountFormPage extends BasePage {

    @FindBy(xpath = "//button[@title='Save']")
    WebElement saveButton;
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @FindAll({
            @FindBy(id = "acc2"),
            @FindBy(css = ".witsSuggestedNameField .input")
    })
    private WebElement accountNameTextField;

    @FindAll({
            @FindBy(id = "acc3"),
            @FindBy(css = "input[title='Search Accounts']")
    })
    private WebElement parentAccountTextField;

    @FindAll({
            @FindBy(id = "acc5"),
            @FindBy(xpath =
                    "//span[text()='Account Number']/parent::label/following-sibling::input")
    })
    private WebElement accountNumberTextField;

    @FindAll({
            @FindBy(id = "acc23"),
            @FindBy(xpath =
                    "//span[text()='Account Site']/parent::label/following-sibling::input")
    })

    private WebElement accountSiteTextField;

    @FindAll({
            @FindBy(id = "acc6"),
            @FindBy(xpath =
                    "//span[text()='Type']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement typeList;

    @FindAll({
            @FindBy(id = "acc7"),
            @FindBy(xpath =
                    "//span[text()='Industry']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement industryList;

    @FindAll({
            @FindBy(id = "acc8"),
            @FindBy(xpath =
                    "//span[text()='Annual Revenue']/parent::label/following-sibling::input")
    })
    private WebElement annualRevenueTextField;

    @FindAll({
            @FindBy(id = "acc9"),
            @FindBy(xpath =
                    "//span[text()='Rating']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement ratingList;

    @FindAll({
            @FindBy(id = "acc10"),
            @FindBy(xpath =
                    "//span[text()='Phone']/parent::label/following-sibling::input")
    })
    private WebElement accountPhone;

    @FindAll({
            @FindBy(id = "acc11"),
            @FindBy(xpath =
                    "//span[text()='Fax']/parent::label/following-sibling::input")
    })
    private WebElement accountFax;

    @FindAll({
            @FindBy(id = "acc12"),
            @FindBy(xpath =
                    "//span[text()='Website']/parent::label/following-sibling::input")
    })
    private WebElement accountWebsite;

    @FindAll({
            @FindBy(id = "acc13"),
            @FindBy(xpath =
                    "//span[text()='Ticker Symbol']/parent::label/following-sibling::input")
    })
    private WebElement accountTickerSymbol;

    @FindAll({
            @FindBy(id = "acc14"),
            @FindBy(xpath =
                    "//span[text()='Ownership']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement ownershipList;

    @FindAll({
            @FindBy(id = "acc15"),
            @FindBy(xpath =
                    "//span[text()='Employees']/parent::label/following-sibling::input")
    })
    private WebElement accountEmployee;

    @FindAll({
            @FindBy(id = "acc16"),
            @FindBy(xpath =
                    "//span[text()='SIC Code']/parent::label/following-sibling::input")
    })
    private WebElement accountSICCode;
    /**
     * Method to set accountEmployee attribute.
     *
     * @param accountSICCode string value.
     */
    public void setAccountSICCodeTextField(final String accountSICCode) {
        driverTools.setTextElement(this.accountSICCode, accountSICCode);
    }

    /**
     * Method to set accountEmployee attribute.
     *
     * @param accountEmployee string value.
     */
    public void setAccountEmployeeTextField(final String accountEmployee) {
        driverTools.setTextElement(this.accountEmployee, accountEmployee);
    }

    /**
     * Method to set accountOwnershipList attribute.
     *
     * @param accountOwnershipList string value.
     */
    public void setAccountOwnershipList(final String accountOwnershipList) {
        //webDriverTools.selectOnComboBox(this.ownershipList, accountOwnershipList);
    }

    /**
     * Method to set accountTickerSymbol attribute.
     *
     * @param accountTickerSymbol string value.
     */
    public void setAccountTickerSymbolTextField(final String accountTickerSymbol) {
        driverTools.setTextElement(this.accountTickerSymbol, accountTickerSymbol);
    }

    /**
     * Method to set accountWebsite attribute.
     *
     * @param accountWebsite string value.
     */
    public void setAccountWebsiteTextField(final String accountWebsite) {
        driverTools.setTextElement(this.accountWebsite, accountWebsite);
    }

    /**
     * Method to set accountPhone attribute.
     *
     * @param accountFax string value.
     */
    public void setAccountFaxTextField(final String accountFax) {
        driverTools.setTextElement(this.accountFax, accountFax);
    }

    /**
     * Method to set accountPhone attribute.
     *
     * @param accountPhone string value.
     */
    public void setAccountPhoneTextField(final String accountPhone) {
        driverTools.setTextElement(this.accountPhone, accountPhone);
    }

    /**
     * Method to set ratingList attribute.
     *
     * @param ratingList string value.
     */
    public void setAccountRatingList(final String ratingList) {
        // webDriverTools.selectOnComboBox(this.ratingList, ratingList);
    }

    /**
     * Method to set accountName attribute.
     *
     * @param accountName string value.
     */
    private void setAccountNameTextField(final String accountName) {
        driverTools.setTextElement(this.accountNameTextField, accountName);
    }

    /**
     * Method to set parentAccount attribute.
     *
     * @param parentAccount the value.
     */
    private void setParentAccountTextField(final String parentAccount) {
        driverTools.setTextElement(this.parentAccountTextField, parentAccount);
        //webDriverTools.selectOnAutoCompleterTextField(this.parentAccountTextField, parentAccount);
    }

    /**
     * Method to set accountNumber attribute.
     *
     * @param accountNumber the value.
     */
    private void setAccountNumberTextField(final String accountNumber) {
        driverTools.setTextElement(this.accountNumberTextField, accountNumber);
    }

    /**
     * Method to set accountSite attribute.
     *
     * @param accountSite the value.
     */
    private void setAccountSiteTextField(final String accountSite) {
        driverTools.setTextElement(this.accountSiteTextField, accountSite);
    }

    /**
     * Method to set type attribute.
     *
     * @param type the value.
     */
    private void setAccountTypeList(final String type) {
        //webDriverTools.selectOnComboBox(this.typeList, type);
    }

    /**
     * Method to set industry attribute.
     *
     * @param industry the value.
     */
    private void setIndustryList(final String industry) {
        //CommonActions.selectOnComboBox(this.industryList, industry);
    }

    /**
     * Method to set annualRevenue attribute.
     *
     * @param annualRevenue the value.
     */
    private void setAnnualRevenueTextField(final String annualRevenue) {
        //CommonWebActions.setTextElement(this.annualRevenueTextField, annualRevenue);
    }

    public AccountDetailsPage setRequeredFiel(String value){
        setAccountNameTextField(value);
        driverTools.clickElement(saveButton);
        return PageFactory.getDetailAccountPage();
    }
}