package com.jalasoft.sfdc.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageClassic extends ProfilePage {
    @FindBy(xpath = "//a[@title='Logout']")
    private WebElement buttonLogout;
    @FindBy(linkText = "My Profile")
    private WebElement linkProfile;
    @FindBy(id = "tailBreadcrumbNode")
    private WebElement userName;

    @Override
    public String isUserNameDisplayed() {
        driverTools.clickElement(linkProfile);
        System.out.println(userName.getText() + " ++++++++++++++++++++++++++++++++++++++++++++++++++");
        return userName.getText().trim();
    }

    /**
     * logout of sales force.
     * @return a new login page.
     */
    @Override
    public LoginPage logout() {
        driverTools.clickElement(buttonLogout);
        return new LoginPage();
    }

    /**
     * wait for a elelemt for
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        driverTools.waitUntilElementDisplayed(linkProfile);
    }
}
