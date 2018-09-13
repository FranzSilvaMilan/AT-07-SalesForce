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
     * {@inheritDoc}.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        driverTools.waitUntilElementDisplayed(profileLink);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String isUserNameDisplayed() {
        driverTools.clickElement(profileLink);
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
