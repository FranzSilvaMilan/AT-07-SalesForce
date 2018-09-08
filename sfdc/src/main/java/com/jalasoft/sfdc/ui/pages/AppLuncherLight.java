package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.account.AccountHomePage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookFormPage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookFormPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

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
    public PriceBookFormPage gotToPriceBookPage() {
        driverTools.clickElement(priceBookButton);
        return new PriceBookFormPageLight();
    }
}
