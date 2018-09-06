package com.jalasoft.sfdc.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageLight extends ProfilePage {
    //By profile = By.cssSelector(".branding-user-profile");
    //By username = By.xpath("//*[@id=\"101:770;a\"]/div[1]/div[1]/div/div[2]/h1/a");
    //@FindBy(xpath = )
    @FindBy(xpath = "(//*[@id=\"101:763;a\"]/div[1]/div[1]/div/div[2]/h1/a")
    private WebElement userProfileName;
    @Override
    public String isUserNameDisplayed() {
        //driver.findElement(profile).click();
        System.out.println(userProfileName.getText() + "asjf´lkasjf´laskjfasjhfklasdhfáshfasjdhflsdkjhfldsjhflas");
        return userProfileName.getText();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
