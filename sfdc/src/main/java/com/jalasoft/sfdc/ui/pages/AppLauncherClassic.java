package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.pages.products.ProductHomePage;
import com.jalasoft.sfdc.ui.pages.products.ProductHomePageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppLauncherClassic extends AppLauncher {

    /**
     * Element product page pop up Classic.
     */
    @FindBy(xpath = "//a[@href='/01t/o'][contains(.,'Products')]")
    WebElement productButton;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Method for go to product home page Classic.
     */
    @Override
    public ProductHomePage goToProductPage() {
        driverTools.clickElement(productButton);
        return new ProductHomePageClassic();
    }
}
