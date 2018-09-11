package com.jalasoft.sfdc.ui.pages.account;

public class AccountListPageLight extends AccountListPage {
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
