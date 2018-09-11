package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPageLight;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.products.ProductListPageLight;
import com.jalasoft.sfdc.ui.pages.products.ProductListPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * AppLauncherLight class.
 *
 * @author Franz Silva.
 * @author Erik Vargas.
 * @author Daniel Sandoval.
 */
public class AppLauncherLight extends AppLauncher {

    @FindBy(xpath = "//span[text()='Accounts' and @class]")
    private WebElement accountButton;

    @FindBy(xpath = "//span[text()='Products' and @class]")
    private WebElement productButton;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        driverTools.waitUntilElementDisplayed(productButton);
    }

    /**
     * Method for go to Account home page Light.
     */
    public AccountListPage gotToAccountPage(){
        driverTools.waitUntilElementDisplayed(accountButton);
        driverTools.clickElement(accountButton);
        return new AccountListPageLight();
    }

    @Override
    public ContactListPage goToContactPage() {
        return null;
    }

    /**
     * Method for go to product home page Light.
     */
    public ProductListPage goToProductPage() {
        driverTools.scrollDown(7);
        driverTools.clickElement(productButton);
        return new ProductListPageLight();
    }
}
