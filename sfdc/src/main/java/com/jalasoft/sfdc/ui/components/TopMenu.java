package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.ProfilePage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * Top bar that contains the user name information, settings and logout options.
 * {@link BasePage} class
 *
 * @author Silvia Valencia
 * @since 7/3/2018.
 */
public abstract class TopMenu extends BasePage {
    @FindAll({
            @FindBy(id = "AllTab_Tab"),
            @FindBy(className = "slds-icon-waffle")
    })
    private WebElement buttonTab;
    @FindAll({
            @FindBy(id = "userNavButton"),
            @FindBy(css = ".branding-user-profile")
    })
    private WebElement userProfile;

    /**
     * change skin
     */
    public abstract void switchSkin();

    /**
     * go to home Page of sales force.
     * @return a page object of home page
     */
    public abstract HomePage goToHomePage();

    /**
     * go to a profile page.
     * @return a new profile page
     */
    public ProfilePage goToProfilePage() {
        //driverTools.waitUntilElementDisplayed(userProfile);
        driverTools.clickElement(userProfile);
        return PageFactory.getProfilePage();
    }

    /**
     * click on profile.
     */
    public void clickProfile() {
        driverTools.clickElement(userProfile);
    }

    /**
     * got to app laucher.
     * @return  a new applauncher.
     */
    public AppLauncher gotToAppLauncher() {
        //driverTools.waitUntilElementDisplayed(userProfile);
        driverTools.clickElement(buttonTab);
        return PageFactory.getAppLauncher();
    }
}
