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

    public abstract String isUserNameDisplayed();
    public abstract LoginPage logout();
}
