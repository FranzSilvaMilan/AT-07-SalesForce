package com.jalasoft.sfdc.ui.pages.priceBook;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.DetailPage;
import com.jalasoft.sfdc.ui.pages.account.DetailAccountPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class PriceBookForm extends BasePage {



    @Override
    public void waitUntilPageObjectIsLoaded(){

    }
    public abstract DetailPage setFields(String name, String description, String active);

}
