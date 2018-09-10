package com.jalasoft.sfdc.ui.pages.account;

public class AccountListPageClassic extends AccountListPage {
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public AccountFormPage clickNewButton() {
        driverTools.waitUntilElementDisplayed(newAccountButton);
        driverTools.clickElement(newAccountButton);
        return new AccountFormPage();
    }
}
