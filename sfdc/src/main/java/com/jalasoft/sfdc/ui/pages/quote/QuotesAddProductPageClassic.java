package com.jalasoft.sfdc.ui.pages.quote;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class QuotesAddProductPageClassic extends QuotesAddProductPage {
    @FindBy(xpath = "//input[contains(@value,'01u0b00002IXVjO')]")
    WebElement selectProductCheckBox;
    @FindBy(xpath = "//input[@title='Select']")
    WebElement selectButton;
    @FindBy(xpath = "//select[contains(@name,'p1')]")
    WebElement selctOptionList;
    @FindBy(xpath = "//input[@title='Save']")
    WebElement saveButton;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public QuoteItemPage  isSelectOptionButton(){
        if(driverTools.isElementDisplayed(selctOptionList)) {
            Select select = new Select(selctOptionList);
            select.selectByVisibleText("Standard");
            driverTools.clickElement(saveButton);
        }
        driverTools.clickElement(selectProductCheckBox);//ToDo
        driverTools.clickElement(selectButton);
        return new QuoteItemPageClassic();
    }
}
