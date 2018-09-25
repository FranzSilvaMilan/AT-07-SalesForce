package com.jalasoft.sfdc.ui.pages.opportunities;

import com.jalasoft.sfdc.entities.Opportunitie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunitieFormPageLight extends OpportunitieFormPage {
    //xpath opportunities
    @FindBy(xpath = "")
    WebElement a;
    @FindBy(xpath = "")
    WebElement b;
    @FindBy(xpath = "")
    WebElement w;
    @FindBy(xpath = "")
    WebElement e;
    @FindBy(xpath = "")
    WebElement r;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public OpportunitieDetailsPage gotToSaveButton(Opportunitie opportunitie) {
        return null;
    }
}
