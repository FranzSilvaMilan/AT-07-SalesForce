package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.By;

/**
 * Autor Franz Silva.
 */
public class AccountListPageLight extends AccountListPage {
    /**
     * {@inheritDoc}.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
    /**
     * {@inheritDoc}.
     */
    @Override
    public AccountFormPage clickNewButton() {
        //driverTools.waitUntilElementDisplayed(newButton);
        driverTools.clickElement(newButton);
        return new AccountFormPageLight();
    }
    /**
     * {@inheritDoc}.
     */
    @Override
    public AccountFormPage clickEditButton(String accountName) {
        return null;
    }

    @Override
    public AccountDetailsPage clickAccountOnList(Account account) {
        String accountXpath = "//a[contains(@class, 'slds-truncate') and contains(@title, '" + account.getName() + "')]";
        driverTools.clickElement(By.xpath(accountXpath));
        return new AccountDetailsPageLight();
    }

    @Override
    public boolean containTheAccount(Account account) {
        String pathAcount = "//a[contains(@class, 'slds-truncate') and contains(@title, '" + account.getName() + "')]";
        return driverTools.isElementDisplayed(By.xpath(pathAcount));
    }

}
