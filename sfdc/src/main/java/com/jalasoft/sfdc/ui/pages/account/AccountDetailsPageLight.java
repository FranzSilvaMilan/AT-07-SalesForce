package com.jalasoft.sfdc.ui.pages.account;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDetailsPageLight extends AccountDetailsPage {
    @FindBy(xpath = "(//*[@class='testonly-outputNameWithHierarchyIcon sfaOutputNameWithHierarchyIcon']/child::span)[1]")
    private WebElement nameAccount;

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
    public String getNameNewAccount() {

        return nameAccount.getText().trim();
    }
}
