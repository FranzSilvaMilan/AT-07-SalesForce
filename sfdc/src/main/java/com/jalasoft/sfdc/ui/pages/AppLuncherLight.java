package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPageLight;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageLight;
import com.jalasoft.sfdc.ui.pages.products.ProductListPageLight;
import com.jalasoft.sfdc.ui.pages.products.ProductListPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppLuncherLight extends AppLauncher {
    @FindBy(xpath = "//span[text()='Accounts' and @class]")
    WebElement accountButton;
    @FindBy(xpath = "//span[text()='Products' and @class]")
    WebElement productButton;
    @FindBy(xpath = "//span[text()='Contacts' and @class]")
    WebElement contactButton;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
    /**
     * Method for go to Account home page Light.
     */
    public AccountListPage gotToAccountPage(){
        driverTools.waitUntilElementDisplayed(accountButton);
        driverTools.clickElement(accountButton);
        return new AccountListPageLight();
    }

    /**
     * Method for go to Contact home page Light.
     */
    @Override
    public ContactListPage goToContactPage() {
        driverTools.clickElement(contactButton);
        return new ContactListPageLight();
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
