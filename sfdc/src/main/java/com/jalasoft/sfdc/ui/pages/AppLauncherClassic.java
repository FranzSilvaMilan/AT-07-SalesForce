package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.pages.priceBook.ListHomeBookPriceClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppLauncherClassic extends AppLauncher {
    @FindBy(xpath = "//a[text()='Price Books']")
    private WebElement priceBookButton;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        driverTools.waitUntilElementDisplayed(priceBookButton);
    }

    @Override
    public ListHomePage gotToBookPage() {
        driverTools.clickElement(priceBookButton);
        return new ListHomeBookPriceClassic();
    }
}
