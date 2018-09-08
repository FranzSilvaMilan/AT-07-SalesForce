package com.jalasoft.sfdc.ui.pages;

import org.openqa.selenium.By;

public class ProfilePageClassic extends ProfilePage {
    @Override
    public String isUserNameDisplayed() {
        driver.findElement(By.linkText("Mi perfil")).click();
        System.out.println(driver.findElement(By.id("tailBreadcrumbNode")).getText()+" ++++++++++++++++++++++++++++++++++++++++++++++++++");
        return driver.findElement(By.id("tailBreadcrumbNode")).getText();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

}
