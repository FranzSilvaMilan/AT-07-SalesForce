package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.ProfilePage;
import com.jalasoft.sfdc.ui.pages.ProfilePageLight;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageLight;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuLight extends TopMenu {
    //By profile = By.cssSelector(".branding-user-profile");
    //@FindBy(css = ".branding-user-profile")
    @FindBy(css = ".branding-user-profile")
    private WebElement userProfile;

    @FindBy(xpath = "(//span[@class='uiImage'])[1]")
    private WebElement userProfileButton;

    @FindBy(xpath = "//*[@class='slds-icon-waffle']")
    private WebElement buttonLoucher;
    @Override
    public void waitUntilPageObjectIsLoaded() {
        //driverTools.waitUntilElementDisplayed(profile);
    }

    @Override
    public void swithSkin() {

    }

    @Override
    public HomePage goToHomePage() {
        return new HomePageLight();
    }

    /**public ProfilePage goToProfilePage(){
        System.out.println("entra a go to profile del light ---------------------------------------------");
        //driver.findElement(profile).click();
        driverTools.waitUntilElementDisplayed(userProfile);

        //driver.findElement(By.cssSelector(".branding-user-profile")).click();
        driverTools.clickElement(userProfileButton);
        //driver.findElement(By.linkText("My Profile")).click();
        return new ProfilePageLight();
    }*/
}
