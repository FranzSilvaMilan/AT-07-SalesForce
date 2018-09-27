package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * @author Franz Silva
 * Form of account.
 */
public abstract class AccountFormPage extends BasePage {

    @FindBy(xpath = "//*[@title='Save']")
    WebElement saveButton;
    public abstract Map<AccountEnum, StrategySetInputs> getStrategyStepMap(final Map<AccountEnum, String> values);
    public abstract List<StrategySetInputs> saveAccount(Account account);
    public abstract AccountDetailsPage clickSaveButton();

}