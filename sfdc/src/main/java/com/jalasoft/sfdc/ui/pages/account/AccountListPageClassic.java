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
        driverTools.waitUntilElementDisplayed(newButton);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public AccountFormPage clickNewButton() {
        //
        driverTools.clickElement(newButton);
        return new AccountFormPageClassic();
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

        return driverTools.isElementDisplayed(By.xpath(xpathAccount));
    }
}
