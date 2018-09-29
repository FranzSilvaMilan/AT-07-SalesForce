package com.jalasoft.sfdc.ui.pages.account;


import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDetailsPageClassic extends AccountDetailsPage {
    @FindBy(xpath = "//*[@class='topName']")
    private WebElement nameAccount;
    @FindBy(xpath = "//*[@title='Edit']")
    private WebElement editButton;
    @FindBy(xpath = "//td[@id='topButtonRow']/input[@name='delete']")
    private WebElement deleteButton;

    /**
     * {@inheritDoc}.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        driverTools.waitUntilElementDisplayed(nameAccount);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String getNameNewAccount() {
        System.out.println(nameAccount.getText() + "   -----------------------------------------------");
        return nameAccount.getText().trim();
    }

    @Override
    public AccountFormPage clickEditButton() {
        driverTools.clickElement(editButton);
        return new AccountFormPageClassic();
    }

    @Override
    public AccountListPage clickDelitButton() {
        driverTools.clickElement(deleteButton);
        acceptAlertDialog();
        return new AccountListPageClassic();
    }

    @Override
    public boolean containsThisElement(String name) {
        String path = String.format("%s%s%s%s%s%s%s%s%s", "//td[contains(@class, 'data2Col')]/div[text()='", name, "']|",
                "//td[contains(@class, 'dataCol')]/div/*[contains(text(), '", name, "')]|",
                "//td[contains(@class, 'dataCol')]/div[contains(text(), '", name, "')]");
        return driverTools.isElementDisplayed(By.xpath(path));
    }

    @Override
    public void getIdAccount(Account account) {
        String url = driver.getCurrentUrl();
        String[] urlSplit = url.split("/");
        account.setId(urlSplit[urlSplit.length - 1]);
    }
}
