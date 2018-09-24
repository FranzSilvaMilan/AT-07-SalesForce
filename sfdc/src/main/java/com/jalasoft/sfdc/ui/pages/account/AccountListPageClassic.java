package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.By;

/**
 * @autor Franz Silva.
 */
public class AccountListPageClassic extends AccountListPage {
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
        return new AccountFormPageClassic();
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
        String locatorNameEdit = "//a[text()='" + account.getName() + "']";
        driverTools.clickElement(By.xpath(locatorNameEdit));
        return new AccountDetailsPageClassic();
    }

    @Override
    public boolean containTheAccount(Account account) {
        String xpathAccount = "//a[text()='" + account.getName() + "']";

        return !driverTools.isElementDisplayed(By.xpath(xpathAccount));
    }
}
