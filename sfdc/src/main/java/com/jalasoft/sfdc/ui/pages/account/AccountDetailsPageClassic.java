package com.jalasoft.sfdc.ui.pages.account;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDetailsPageClassic extends AccountDetailsPage {
    @FindBy(xpath = "(//*[@class='testonly-outputNameWithHierarchyIcon sfaOutputNameWithHierarchyIcon']/child::span)[1]")
    private WebElement nameAccount;

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
}
