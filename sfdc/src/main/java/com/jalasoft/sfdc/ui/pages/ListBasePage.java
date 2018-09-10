package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public abstract class ListBasePage extends BasePage {

    //@FindBy(xpath = "//a[@class='forceActionLink' and @role='button' and @title='New']")
    @FindBy(xpath = "//*[@title='New']")
    public WebElement newAccountButton;
}