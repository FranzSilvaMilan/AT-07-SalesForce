package com.jalasoft.sfdc.ui.pages.priceBook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceBookFormPageLight extends PriceBookFormPage {

    @FindBy(xpath = "//a[@class='forceActionLink' and @role='button' and @title='New']")
    public WebElement newAccountButton;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public PriceBookListPage clickNewButton() {
        driverTools.clickElement(newAccountButton);
        return new PriceBookListPageLight();
    }


    //@Override
    /*public PriceBookListPage getClickSavePriceBook() {
        return null;
    }*/
}
