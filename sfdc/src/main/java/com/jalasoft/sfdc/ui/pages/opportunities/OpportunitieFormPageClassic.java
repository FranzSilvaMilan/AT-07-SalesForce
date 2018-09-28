package com.jalasoft.sfdc.ui.pages.opportunities;

import com.jalasoft.sfdc.entities.Opportunitie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OpportunitieFormPageClassic extends OpportunitieFormPage {

    @FindBy(xpath = "//input[contains(@name,'opp3')]")
    private WebElement opportunitiesNameInput;
    @FindBy(xpath = "//input[contains(@name,'opp9')]")
    private WebElement opportunitiesClosedateInput;
    @FindBy(xpath = "//select[contains(@name,'opp11')]")
    private WebElement opportunitiesStageInput;

    @FindBy(xpath = "//input[contains(@tabindex,'18')]")
    private WebElement saveButton;
    @FindBy(xpath = "//*[@id='opp2']")
    private WebElement acction;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method that set field of Opportunite class.
     * @param opportunitie - is the object that contains the opportunitie's data.
     * @return Opportunitie Details Page Classic.
     */
    @Override
    public OpportunitieDetailsPage gotToSaveButton(Opportunitie opportunitie) {
        driverTools.setInputField(opportunitiesNameInput, opportunitie.getName());
        driverTools.clickElement(opportunitiesStageInput);
        Select select = new Select(opportunitiesStageInput);
        select.selectByVisibleText(opportunitie.getStage());
        driverTools.setInputField(opportunitiesClosedateInput, opportunitie.getCloseDate());
        driverTools.clickElement(acction);
        driverTools.clickElement(saveButton);
        return new OpportunitieDetailsPageClassic();
    }
}
