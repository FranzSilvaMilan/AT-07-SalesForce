package com.jalasoft.sfdc.ui.pages.contact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ContacDetailsPageLight class.
 *
 * @author Daniel Sandoval.
 * @since 9/11/2018.
 */
public class ContactDetailsPageLight extends ContactDetailsPage {
    @FindBy(xpath = "(//*[@class='testonly-outputNameWithHierarchyIcon sfaOutputNameWithHierarchyIcon']//child::span)[1]")
    WebElement contactlabelName;

    /**
     * Method that get the last name created.
     *
     * @return - last name.
     */
    @Override
    public String isContactNameDisplayed() {
        return contactlabelName.getText().trim();
    }

}
