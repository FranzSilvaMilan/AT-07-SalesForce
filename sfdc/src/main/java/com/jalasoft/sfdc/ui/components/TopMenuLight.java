package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageLight;

public class TopMenuLight extends TopMenu {

    /**
     * {@inheritDoc}.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void switchSkin() {

    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public HomePage goToHomePage() {
        return new HomePageLight();
    }
}
