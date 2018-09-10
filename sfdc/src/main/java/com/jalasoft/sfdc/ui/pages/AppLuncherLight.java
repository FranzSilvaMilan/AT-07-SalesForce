package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.account.AccountHomePage;
import com.jalasoft.sfdc.ui.pages.products.ProducHomePageLight;
import com.jalasoft.sfdc.ui.pages.products.ProductHomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class AppLuncherLight extends AppLauncher {
    @FindBy(xpath = "//span[text()='Accounts' and @class]")
    WebElement accountButton;

    /**
     * Element product page pop up Light.
     */
    @FindBy(xpath = "//span[text()='Products' and @class]")
    WebElement productButton;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
    public AccountFormPage gotToAccountPage(){
        driverTools.waitUntilElementDisplayed(accountButton);
        driverTools.clickElement(accountButton);
        return new AccountFormPage();
    }

    /**
     * Method for go to product home page Light.
     */
    public ProductHomePage goToProductPage() {
        driverTools.clickElement(productButton);
        driverTools.scrollDown(5);
        return new ProducHomePageLight();
    }

}
