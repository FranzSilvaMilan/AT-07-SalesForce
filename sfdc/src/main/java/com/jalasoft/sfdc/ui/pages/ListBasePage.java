package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ListBasePage class.
 *
 * @author Franz Silva.
 * @author Erik Vargas.
 * @author Daniel Sandoval.
 */
public abstract class ListBasePage extends BasePage {

    //@FindBy(xpath = "//a[@class='forceActionLink' and @role='button' and @title='New']")
    @FindBy(xpath = "//*[@title='New']")
    public WebElement newButton;
}
