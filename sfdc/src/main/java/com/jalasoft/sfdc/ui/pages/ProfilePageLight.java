package com.jalasoft.sfdc.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageLight extends ProfilePage {
    @FindBy(xpath = "//h1[@class='profile-card-name']/child::a")
    private WebElement userProfileName;
    @Override
    public String isUserNameDisplayed() {
        driverTools.waitUntilElementDisplayed(userProfileName);
        System.out.println(userProfileName.getText() + "+++++++++++++++++++++++++++++");
        return userProfileName.getText();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

}
