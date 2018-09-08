package com.jalasoft.sfdc.ui.pages.priceBook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceBookListPageLight extends PriceBookListPage {

    @FindBy(xpath = "//*[@aria-required='true']")
    WebElement fiellTitle;

    @FindBy(xpath = "(//*[@class=' input'])[2]")
    WebElement fiellDesription;

    @FindBy(xpath = "(//*[@type='checkbox'])[4]")
    WebElement checkOptionActive;

    @FindBy(xpath = "//div/button[3]/span")
    WebElement saveButton;

    @Override
    public PriceBookCreatedPage getClickSavePriceBook(String title, String description) {
        //return new PriceBookListPageLight();
        driverTools.setInputField(fiellTitle, title);
        driverTools.setInputField(fiellDesription, description);
        driverTools.clickElement(checkOptionActive);
        driverTools.clickElement(saveButton);
        return new PriceBookCreatedPageLight();
    }

/*    @Override
    public PriceBookCreatedPage clickSavePriceBook() {
        driverTools.clickElement(saveButton);
        return new PriceBookCreatedPageLight();
    }*/
}
