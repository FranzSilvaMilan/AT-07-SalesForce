package com.jalasoft.sfdc.ui.pages.opportunities;

import com.jalasoft.sfdc.entities.Opportunitie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OpportunitieFormPageClassic extends OpportunitieFormPage {
    //xpath opportunities
    @FindBy(xpath = "//input[contains(@name,'opp3')]")
    WebElement opportunitiesNameInput;
    @FindBy(xpath = "//input[contains(@name,'opp9')]")
    WebElement opportunitiesClosedateInput;
    @FindBy(xpath = "//select[contains(@name,'opp11')]")
    WebElement opportunitiesStageInput;

    @FindBy(xpath = "//input[contains(@tabindex,'18')]")
    WebElement saveButton;
    @FindBy(xpath = "//*[@id='opp2']")
    WebElement acction;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }


    @Override
    public OpportunitieDetailsPage gotToSaveButton(Opportunitie opportunitie) {
        driverTools.setInputField(opportunitiesNameInput, opportunitie.getAccountName());

        driverTools.clickElement(opportunitiesStageInput);
        Select select = new Select(opportunitiesStageInput);
        select.selectByVisibleText(opportunitie.getStage());
        driverTools.setInputField(opportunitiesClosedateInput, opportunitie.getCloseDate());
        driverTools.clickElement(acction);
        //driverTools.clickElement(opportunitiesStageInput);
       // driverTools.setInputField(opportunitiesStageInput, opportunitie.getStage());
        //driverTools.setInputField(opportunitiesNameInput, opportunitie.getAccountName());
        driverTools.clickElement(saveButton);
        return new OpportunitieDetailsPageClassic();
    }
}
