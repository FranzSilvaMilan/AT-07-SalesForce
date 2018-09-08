package com.jalasoft.sfdc.ui.pages.priceBook;

import com.jalasoft.sfdc.ui.HomeBasePage;
import org.openqa.selenium.By;

public abstract class PriceBookPage extends HomeBasePage {
    By buttonNew;
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
    public  abstract  PriceBookFormPage clickButtonNew();
}
