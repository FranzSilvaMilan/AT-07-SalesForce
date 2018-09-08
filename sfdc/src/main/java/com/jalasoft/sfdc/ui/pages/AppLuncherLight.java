package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookPage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppLuncherLight extends AppLauncher {
    @FindBy(xpath = "//span[text()='Accounts' and @class]")
    WebElement accountButton;

    @FindBy(xpath = "//div/ul/li[26]/a")
    WebElement priceBookButton;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
    public AccountFormPage gotToAccountPage(){
        driverTools.waitUntilElementDisplayed(accountButton);
        driverTools.clickElement(accountButton);
        return new AccountFormPage();
    }

    @Override
    public PriceBookPage gotToPriceBookPage() {
        driverTools.clickElement(priceBookButton);
        return new PriceBookPageLight();

    }
}
