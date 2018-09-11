package com.jalasoft.sfdc.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ProfilePageClassic class.
 *
 * @author Franz Silva.
 * @author Erik Vargas.
 * @author Daniel Sandoval.
 */
public class ProfilePageClassic extends ProfilePage {
    @FindBy(xpath = "//a[@title='Logout']")
    private WebElement logoutButton;

    @FindBy(linkText = "My Profile")
    private WebElement profileLink;

    @FindBy(id = "tailBreadcrumbNode")
    private WebElement userProfileNameLabel;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        driverTools.waitUntilElementDisplayed(profileLink);
    }

    /**
     * get user name displayed
     * @return user name
     */
    @Override
    public String isUserNameDisplayed() {
        driverTools.clickElement(profileLink);
        return userProfileNameLabel.getText().trim();
    }

    /**
     * logout of sales force.
     * @return a new login page.
     */
    @Override
    public LoginPage logout() {
        driverTools.clickElement(logoutButton);
        return new LoginPage();
    }
}
