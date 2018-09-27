package com.jalasoft.sfdc.ui.pages.opportunities;

import com.jalasoft.sfdc.ui.pages.contact.ContactFormPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunitieListPageClassic extends OpportunitieListPage {
    private static final String BUTTON_EXIT = "//*[@id='tryLexDialogX']";
    @FindBy(xpath = BUTTON_EXIT)
    private WebElement closeWindows;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method that click in New Button.
     * @return new Form page Classic.
     */
    @Override
    public OpportunitieFormPage gotToNewButton() {
        driverTools.clickElement(newButton);
        return new OpportunitieFormPageClassic();
    }
}
