package com.jalasoft.sfdc.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ProfilePageLight class.
 *
 * @author Franz Silva.
 * @author Erik Vargas.
 * @author Daniel Sandoval.
 */
public class ProfilePageLight extends ProfilePage {
    @FindBy(xpath = "//h1[@class='profile-card-name']/child::a")
    private WebElement userProfileNameLabel;

    @FindBy(css = ".profile-link-label.logout.uiOutputURL")
    private WebElement logoutButton;

    /**
     * {@inheritDoc}.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        driverTools.waitUntilElementDisplayed(userProfileNameLabel);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String isUserNameDisplayed() {
        return userProfileNameLabel.getText().trim();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public LoginPage logout() {
        driverTools.clickElement(logoutButton);
        return new LoginPage();
    }
}
