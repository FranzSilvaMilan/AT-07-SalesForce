package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.pages.ListBasePage;
/**
 * @author Franz Silva
 * Represent account home page that have a list of accounts.
 */
public abstract class AccountListPage extends ListBasePage {
    /**
     * click on new button on account list home page.
     *
     * @return a new form of account
     */
    public abstract AccountFormPage clickNewButton();

    /**
     * click on edit button button on accountName list home page.
     *
     * @param accountName is a name of account that need edit
     * @return
     */
    public abstract AccountFormPage clickEditButton(String accountName);
    public abstract AccountDetailsPage clickAccountOnList(Account account);
    public abstract boolean containTheAccount(Account account);
}
