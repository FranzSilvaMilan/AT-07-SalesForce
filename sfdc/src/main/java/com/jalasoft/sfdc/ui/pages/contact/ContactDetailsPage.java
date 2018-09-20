package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.BasePage;

/**
 * ContacDetailsPage class.
 *
 * @author Daniel Sandoval.
 * @since 9/11/2018.
 */
public abstract class ContactDetailsPage extends BasePage {



    /**
     * Abstract method that verify if is created to new Contact.
     *
     * @return - the last name created.
     */
    public abstract String isContactNameDisplayed();

    public abstract void clickOptionEditButton(Contact contact);
    public abstract void isSaveOfChangeMade();

    /**
     * The method that delete of the contact
     */
    public abstract void clickOptionDelet();
    public abstract boolean isNameChangeDisplayed(Contact contact);
    public abstract boolean isTitleChangeDisplayed(Contact contact);
    public abstract boolean isMobileChangeDisplayed(Contact contact);

}
