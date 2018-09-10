package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.account.AccountHomePage;
import com.jalasoft.sfdc.ui.pages.priceBook.ListHomeBookPriceLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class AppLuncherLight extends AppLauncher {
    @FindBy(xpath = "//span[text()='Accounts' and @class]")
    WebElement accountButton;
    @FindBy(xpath = "//span[text()='Price Books' and @class]")
    private WebElement priceBookButton;
    @Override
    public void waitUntilPageObjectIsLoaded() {
        driverTools.waitUntilElementDisplayed(accountButton);
    }
    public AccountFormPage gotToAccountPage(){
        driverTools.clickElement(accountButton);
        return new AccountFormPage();
    }

    @Override
    public ListHomePage gotToBookPage() {
        driverTools.clickElement(priceBookButton);
        return new ListHomeBookPriceLight();
    }
}
