package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ContacDetailsPageClassic class.
 *
 * @author Daniel Sandoval.
 * @since 9/11/2018.
 */
public class ContactDetailsPageClassic extends ContactDetailsPage {
    @FindBy(xpath = "//h2[contains(@class,'topName')]")
    WebElement contactLabelName;

    /**
     * Method that get the last name created.
     *
     * @return - last name.
     */
    @Override
    public String isContactNameDisplayed() {
        return contactLabelName.getText().trim();
    }

    @Override
    public void clickOptionEdit(Contact contact) {

    }

    @Override
    public void isSaveOfChangeMade() {
       // return null;
    }

    @Override
    public String isMobileChangeDisplayed() {
        return null;
    }

    @Override
    public String isTitleChangeDisplayed() {
        return null;
    }

}
