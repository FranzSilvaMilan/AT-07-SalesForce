package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.BasePage;

public abstract class AccountDetailsPage extends BasePage {
    /**
     * get a name for confirm if account is created.
     * @return a name of new account
     */
    public abstract String getNameNewAccount();


    public abstract AccountFormPage clickEditButton();
    public abstract AccountListPage clickDelitButton();

    public abstract boolean containsThisElement(String name);
    public abstract void getIdAccount(Account account);
}
