package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.selenium.WebDriverTools;
import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public abstract class ProfilePage extends BasePage {
    public abstract String isUserNameDisplayed();

    public abstract LoginPage logout();
}
