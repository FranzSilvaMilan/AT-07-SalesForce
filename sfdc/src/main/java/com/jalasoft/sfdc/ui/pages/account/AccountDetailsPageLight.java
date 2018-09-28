package com.jalasoft.sfdc.ui.pages.account;


import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDetailsPageLight extends AccountDetailsPage {
    @FindBy(xpath = "(//*[@class='testonly-outputNameWithHierarchyIcon sfaOutputNameWithHierarchyIcon']/child::span)[1]")
    private WebElement nameAccount;
    @FindBy(xpath = "//a[@title='Edit']")
    private WebElement editButton;
    @FindBy(xpath = "//a[@title='Delete']")
    private WebElement deleteButton;
    @FindBy(xpath = "//span[text()='Details']")
    private WebElement sectionDetails;
    @FindBy(css = ".sldsButtonHeightFix")
    private WebElement optionsAccount;

    @FindBy(xpath = "//button[contains(@class, 'slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton')]")
    private WebElement deleteConfirnButton;

    private By moreOptionButton = By.xpath("//li[@class='slds-button slds-button--icon-border-filled oneActionsDropDown']/div");


    /**
     * {@inheritDoc}.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        driverTools.waitUntilElementDisplayed(optionsAccount);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String getNameNewAccount() {
        driverTools.sleepMilliSeconds(3000);
        return nameAccount.getText().trim();
    }

    @Override
    public AccountFormPage clickEditButton() {
        driverTools.clickElement(sectionDetails);
        driverTools.moveAndClickElement(optionsAccount);
        driverTools.clickElement(editButton);
        return new AccountFormPageLight();
    }

    @Override
    public AccountListPage clickDelitButton() {
        driverTools.clickElement(optionsAccount);
        driverTools.clickElement(deleteButton);
        driverTools.clickElement(deleteConfirnButton);
        return new AccountListPageLight();
    }

    @Override
    public boolean containsThisElement(String name) {
        String path = String.format("%s%s%s%s%s", "//span[contains(@class,'slds-form-element__static')]//span//a[text()='"
                , name, "'] | //span[contains(@class,'slds-form-element__static')]//span[text()='", name, "']");
        return driverTools.isElementDisplayed(By.xpath(path));
    }

    @Override
    public void getIdAccount(Account account) {
        String url = driver.getCurrentUrl();
        String[] urlSplit = url.split("/");
        account.setId(urlSplit[urlSplit.length-2]);
    }

}
