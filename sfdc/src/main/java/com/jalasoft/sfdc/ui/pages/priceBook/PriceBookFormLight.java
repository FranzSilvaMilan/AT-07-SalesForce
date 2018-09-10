package com.jalasoft.sfdc.ui.pages.priceBook;

import com.jalasoft.sfdc.ui.pages.DetailPage;
import com.jalasoft.sfdc.ui.pages.account.DetailAccountPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceBookFormLight extends PriceBookForm{
    @FindBy(xpath = "//button[@title='Save']")
    WebElement saveButton;
    @FindBy(xpath = "(//div[@class='uiInput uiInputText uiInput--default uiInput--input']/child::input)[1]")
    private WebElement inputName;

    @FindBy(xpath = "(//div[@class='uiInput uiInputText uiInput--default uiInput--input']/child::input)[2]")
    private WebElement inputDescription;
    @FindBy(xpath = "//div[@class='uiInput uiInputCheckbox uiInput--default uiInput--checkbox']/child::input")
    private WebElement checkBox;

    public DetailPage setFields(String name, String description, String active) {
        driverTools.setInputField(inputName, name);
        driverTools.setInputField(inputDescription, description);
        if (active.equalsIgnoreCase("true")) {
            driverTools.clickElement(checkBox);
        }
        driverTools.clickElement(saveButton);
        return new DetailAccountPageClassic();
    }
}
