package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.products.ProductListPageLight;
import com.jalasoft.sfdc.ui.pages.products.ProductListPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    public ProductListPage goToProductPage() {
        driverTools.clickElement(productButton);
        driverTools.scrollDown(5);
        return new ProductListPageLight();
    }

}
