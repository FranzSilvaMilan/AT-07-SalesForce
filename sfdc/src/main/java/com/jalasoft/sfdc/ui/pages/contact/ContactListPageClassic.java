package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ContactListPageClassic class.
 *
 * @author Daniel Sandoval.
 * @since 9/11/2018.
 */
public class ContactListPageClassic extends ContactListPage {
    private static final String BUTTON_EXIT = "//*[@id='tryLexDialogX']";
    @FindBy(xpath = BUTTON_EXIT)
    private WebElement closeWindows;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

        driverTools.waitUntilElementDisplayed(newButton);
    }

    /**
     * Method that clicks on the option of the New button.
     *
     * @return - new page Classic.
     */
    @Override
    public ContactFormPage gotToNewButton() {
        if(driverTools.isElementDisplayed(closeWindows)) {
            driverTools.clickElement(closeWindows);
        }
        driverTools.clickElement(newButton);
        return new ContactFormPageClassic();
    }

    @Override
    public boolean isContatcNotDisplayed(Contact contact) {
        return driverTools.isElementDisplayed(By.xpath("//*[@id='mru0030b0000269Gfp']/child::a//following-sibling::span[text()='"+contact.getFirstName()+" "+contact.getLastName()+"']"));
    }
}
