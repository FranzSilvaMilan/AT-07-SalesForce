package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.LoginPage;
import com.jalasoft.sfdc.ui.pages.ProfilePage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import org.openqa.selenium.By;
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




    public abstract void swithSkin();

    public LoginPage logout(){
        return new LoginPage();
    }

    public abstract HomePage goToHomePage ();

    public ProfilePage goToProfilePage(){
        driverTools.waitUntilElementDisplayed(userProfile);
        driverTools.clickElement(userProfile);
        return PageFactory.getProfilePage();

    }
    public AppLauncher gotToAppLaucher(){
        driverTools.waitUntilElementDisplayed(userProfile);
        driverTools.clickElement(buttonTab);
        return PageFactory.getAppLauncher();
    }

}
