package com.jalasoft.sfdc.ui.pages.account;


import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDetailsPageClassic extends AccountDetailsPage {
    @FindBy(xpath = "//*[@class='topName']")
    private WebElement nameAccount;
    @FindBy(xpath ="//*[@title='Edit']")
    private WebElement editButton;
    /**
     * {@inheritDoc}.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
    }//driverTools.waitUntilElementDisplayed(nameAccount);    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String getNameNewAccount() {
        System.out.println(nameAccount.getText() + "   -----------------------------------------------");
        return nameAccount.getText().trim();
    }

    @Override
    public AccountFormPage clickAccount(Account account) {
        String locatorNameEdit = "//a[text()='" + account.getName() + "']";
        driverTools.clickElement(By.xpath(locatorNameEdit));
        return new AccountFormPage();
    }

    @Override
    public AccountFormPage clickEditButton() {
        driverTools.clickElement(editButton);
        return new AccountFormPage();
    }
}
