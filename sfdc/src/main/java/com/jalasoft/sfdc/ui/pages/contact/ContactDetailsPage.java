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
     * @return - the last name created.
     */
    public abstract String isContactNameDisplayed();

    /**
     * Method that you click on the Edit button.
     */
    public abstract void clickEditButton();

    /**
     * The method allows us to edit the created contact.
     * @param contact - class object Contact.
     */
    public abstract void setNewChangesToContact(Contact contact);

    /**
     * The method that delete of the contact
     */
    public abstract void clickDeletedButton();

    /**
     * The name of user is displayed in GUI.
     * @param contact - class object Contact.
     * @return if is displayed true or false.
     */
    public abstract boolean isNameChangeDisplayed(Contact contact);

    /**
     * The title of user is displayed in GUI.
     * @param contact - class object Contact.
     * @return if is displayed true or false.
     */
    public abstract boolean isTitleChangeDisplayed(Contact contact);

    /**
     * The mobile of user is displayed in GUI.
     * @param contact - class object Contact.
     * @return if is displayed true or false.
     */
    public abstract boolean isMobileChangeDisplayed(Contact contact);

    public abstract void getIdUrlCurrent(Contact contact);

}
