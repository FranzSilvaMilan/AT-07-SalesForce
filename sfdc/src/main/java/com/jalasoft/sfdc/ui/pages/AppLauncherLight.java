package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPageLight;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitieListPage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookListPage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookListPageLight;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageLight;
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

    @FindBy(xpath = "//span[text()='Price Books' and @class]")
    private WebElement priceBookButton;

    @FindBy(xpath = "//span[text()='Contacts' and @class]")
    private WebElement contactButton;

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
        driverTools.scrollDown(7);
        driverTools.clickElement(productButton);
        return new ProductListPageLight();
    }

    /**
     * Method for go to Price Book home page Light.
     */
    @Override
    public PriceBookListPage goToPriceBookPage() {
        driverTools.clickElement(priceBookButton);
        return new PriceBookListPageLight();
    }

    /**
     * Method for go to Opportunities home page Light.
     */
    @Override
    public OpportunitieListPage goToOpportunitiesPage() {
        return null;
    }
}
