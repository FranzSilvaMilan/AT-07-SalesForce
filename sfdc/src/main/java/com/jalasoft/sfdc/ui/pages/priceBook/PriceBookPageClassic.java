package com.jalasoft.sfdc.ui.pages.priceBook;

import org.openqa.selenium.By;

public class PriceBookPageClassic extends PriceBookPage {

    public  PriceBookPageClassic(){
        buttonNew = By.xpath("//input[@title='New]");
    }
    @Override
    public PriceBookFormPage clickButtonNew() {
        driverTools.clickElement(buttonNew);
        return new PriceBookFormPageLight();
    }
}
