package com.jalasoft.sfdc.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageLight extends ProfilePage {
    @FindBy(xpath = "//h1[@class='profile-card-name']/child::a")
    private WebElement userProfileName;
    @FindBy(css = ".profile-link-label.logout.uiOutputURL")
    private WebElement buttonLogout;

    /**
     * get user name displayed
     * @return
     */
    @Override
    public String isUserNameDisplayed() {
        System.out.println(userProfileName.getText() + "+++++++++++++++++++++++++++++");
        return userProfileName.getText().trim();
    }

    /**
     * get out of sales force.
     * @return a new login page.
     */
    @Override
    public LoginPage logout() {
        driverTools.clickElement(buttonLogout);
        return new LoginPage();
    }

    /**
     * wait for a element is displayed for load tthe page.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        driverTools.waitUntilElementDisplayed(userProfileName);
    }
}
