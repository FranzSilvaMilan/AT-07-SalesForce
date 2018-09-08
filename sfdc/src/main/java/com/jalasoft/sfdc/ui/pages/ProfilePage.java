package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.selenium.WebDriverTools;
import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public abstract class ProfilePage extends BasePage {
    /*@FindBy(xpath = "//*[@id='133:204;a']//span[@class='uiImage']")
    private WebElement imageIcon;
    @FindBy(xpath = "//*[@class='profile-card-toplinks']//child::a[text()='Settings']")
    private WebElement optionSettings;
    @FindBy(id ="PersonalInformationSetup:editPage:pageBlock:lastName")
    private WebElement alias;

    @FindBy(xpath = "//span[@id=\"PersonalInformationSetup:editPage:pageBlock:userName\"].getText()")
    private WebElement usernameProfile;*/

    //WebDriverTools webDriverTools;
    /*HomePageLight(){
        webDriverTools = new WebDriverTools();
    }*/

    /*public void goProfile() {
        webDriverTools.clickElement(imageIcon);
        webDriverTools.clickElement(optionSettings);
    }*/

    /*public String isUserNameDisplayed(){
        webDriverTools.clickElement(imageIcon);
        webDriverTools.clickElement(optionSettings);
        return usernameProfile.getText();
    }*/
    public abstract String isUserNameDisplayed();

}
