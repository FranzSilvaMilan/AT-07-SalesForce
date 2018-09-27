package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPageClassic;
import com.jalasoft.sfdc.ui.pages.account.AccountListPageLight;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageClassic;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitieListPage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitieListPageClassic;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookListPage;
import com.jalasoft.sfdc.ui.pages.priceBook.PriceBookListPageClassic;
import com.jalasoft.sfdc.ui.pages.products.ProductListPage;
import com.jalasoft.sfdc.ui.pages.products.ProductListPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * AppLauncherClassic class.
 *
 * @author Franz Silva.
 * @author Erik Vargas.
 * @author Daniel Sandoval.
 */
public class AppLauncherClassic extends AppLauncher {

    @FindBy(xpath = "//a[text()='Accounts']")
    private WebElement accountButton;

    @FindBy(xpath = "//a[@class='listRelatedObject contactBlock title']")
    private WebElement contactButton;

    @FindBy(xpath = "//a[@href='/01t/o'][contains(.,'Products')]")
    private WebElement productButton;

    @FindBy(xpath = "//*[contains(text(),'Price Books')]")
    private WebElement priceBookButton;

    @FindBy(xpath = "//a[contains(.,'Opportunities')]")
    private WebElement opportunitiesButton;

    @FindBy(xpath = "//*[@id='tryLexDialogX']")
    private WebElement closeWindows;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for go to Account home page Classic.
     */
    public AccountListPage gotToAccountPage() {
        driverTools.clickElement(accountButton);
        if (driverTools.isElementDisplayed(closeWindows)) {
            driverTools.clickElement(closeWindows);
        }
        return new AccountListPageClassic();
    }

    /**
     * Method for go to Contact home page Classic.
     */
    @Override
    public ContactListPage goToContactPage() {
        driverTools.clickElement(contactButton);
        if (driverTools.isElementDisplayed(closeWindows)) {
            driverTools.clickElement(closeWindows);
        }
        return new ContactListPageClassic();
    }

    /**
     * Method for go to Product home page Classic.
     */
    @Override
    public ProductListPage goToProductPage() {
        driverTools.clickElement(productButton);
        return new ProductListPageClassic();
    }

    /**
     * Method for go to Price Book home page Classic.
     */
    @Override
    public PriceBookListPage goToPriceBookPage() {
        driverTools.clickElement(priceBookButton);
        return new PriceBookListPageClassic();
    }

    /**
     * Method for go to Opportunities home page Classic.
     */
    @Override
    public OpportunitieListPage goToOpportunitiesPage() {
        driverTools.clickElement(opportunitiesButton);
        if (driverTools.isElementDisplayed(closeWindows)) {
            driverTools.clickElement(closeWindows);
        }
        return new OpportunitieListPageClassic();
    }
}
