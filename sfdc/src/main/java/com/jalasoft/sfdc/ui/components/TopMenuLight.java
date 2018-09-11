package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageLight;

public class TopMenuLight extends TopMenu {

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public void switchSkin() {

    }

    @Override
    public HomePage goToHomePage() {
        return new HomePageLight();
    }
}
