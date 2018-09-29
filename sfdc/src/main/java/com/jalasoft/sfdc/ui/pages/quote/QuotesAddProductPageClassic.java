package com.jalasoft.sfdc.ui.pages.quote;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class QuotesAddProductPageClassic extends QuotesAddProductPage {
    @FindBy(xpath = "//input[contains(@value,'01u0b00002IXVjO')]")
    private WebElement selectProductCheckBox;//ToDo
    @FindBy(xpath = "//input[@title='Select']")
    private WebElement selectButton;
    @FindBy(xpath = "//select[contains(@name,'p1')]")
    private WebElement selctOptionList;
    @FindBy(xpath = "//input[@title='Save']")
    private WebElement saveButton;

    private static final String PRODUCT_NAME = "//span[text()='%s']/ancestor::div[contains(@class,'x-grid3-row')]/child::table/child::tbody/child::tr/child::td/child::div/child::input";

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     *
     * @param nameProduct - name of the product that is save.
     * @return Item Page Classic.
     */
    @Override
    public QuoteItemPage  isSelectOptionButton(String nameProduct){
        if(driverTools.isElementDisplayed(selctOptionList)) {
            Select select = new Select(selctOptionList);
            select.selectByVisibleText("Standard");
            driverTools.clickElement(saveButton);
        }
        driverTools.clickElement(By.xpath(String.format(PRODUCT_NAME, nameProduct)));
        driverTools.clickElement(selectButton);
        return new QuoteItemPageClassic();
    }
}
