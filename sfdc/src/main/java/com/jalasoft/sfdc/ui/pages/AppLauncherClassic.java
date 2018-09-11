package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPageLight;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageClassic;
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
    public AccountListPage gotToAccountPage(){
        driverTools.waitUntilElementDisplayed(accountButton);
        driverTools.clickElement(accountButton);
        return new AccountListPageLight();
    }

    /**
     * Method for go to Contact home page Classic.
     */
    @Override
    public ContactListPage goToContactPage() {
        driverTools.clickElement(contactButton);
        driverTools.clickElement(closeWindows);
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
}
