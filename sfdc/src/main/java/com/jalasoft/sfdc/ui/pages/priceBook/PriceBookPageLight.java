package com.jalasoft.sfdc.ui.pages.priceBook;

import org.openqa.selenium.By;

public class PriceBookPageLight extends PriceBookPage {
    public PriceBookPageLight(){
        buttonNew = By.xpath("//a[@title='New]");
    }

    public PriceBookFormPage clickButtonNew(){
        driverTools.clickElement(buttonNew);
        return new PriceBookFormPageLight();
    }
}
