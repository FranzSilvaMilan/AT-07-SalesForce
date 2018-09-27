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
        driverTools.waitUntilElementDisplayed(newButton);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public AccountFormPage clickNewButton() {
        driverTools.clickElement(newButton);
        return new AccountFormPageLight();
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
