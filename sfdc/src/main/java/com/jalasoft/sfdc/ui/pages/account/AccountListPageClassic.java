package com.jalasoft.sfdc.ui.pages.account;

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
        driverTools.waitUntilElementDisplayed(newButton);
        driverTools.clickElement(newButton);
        return new AccountFormPage();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public AccountFormPage clickEditButton(String accountName) {
        return null;
    }
}
