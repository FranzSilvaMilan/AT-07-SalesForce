package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppLauncherClassic extends AppLauncher {
    @FindBy(xpath = "//a[@class='listRelatedObject contactBlock title']")
    WebElement contactButton;
    @FindBy(xpath = "//*[@id=\"tryLexDialogX\"]")
    WebElement closeWindows;
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public ContactListPage goToContactPage(){
        driverTools.clickElement(contactButton);
        driverTools.clickElement(closeWindows);
        return new ContactListPageClassic();
    }
}
