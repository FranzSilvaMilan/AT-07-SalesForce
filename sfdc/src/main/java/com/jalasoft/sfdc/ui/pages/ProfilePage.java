package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.BasePage;

/**
 * ProfilePage class.
 *
 * @author Franz Silva.
 * @author Erik Vargas.
 * @author Daniel Sandoval.
 */
public abstract class ProfilePage extends BasePage {
    /**
     * get a user name of sales forece profile
     * @return name of user.
     */
    public abstract String isUserNameDisplayed();

    /**
     * log out of sales force.
     * @return a page login
     */
    public abstract LoginPage logout();
}
