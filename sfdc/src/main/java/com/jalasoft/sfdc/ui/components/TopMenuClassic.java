package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageClassic;

public class TopMenuClassic extends TopMenu {

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
        return new HomePageClassic();
    }
}
