package com.jalasoft.sfdc.ui.pages.opportunities;

public class OpportunitieListPageLight extends OpportunitieListPage {
    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public OpportunitieFormPage gotToNewButton() {
        driverTools.clickElement(newButton);
        return new OpportunitieFormPageLight();
    }
}
