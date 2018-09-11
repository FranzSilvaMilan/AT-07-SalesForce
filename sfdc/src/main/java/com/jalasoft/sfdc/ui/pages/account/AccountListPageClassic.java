package com.jalasoft.sfdc.ui.pages.account;

public class AccountListPageClassic extends AccountListPage {
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public AccountFormPage clickNewButton() {
        driverTools.waitUntilElementDisplayed(newButton);
        driverTools.clickElement(newButton);
        return new AccountFormPage();
    }
}
