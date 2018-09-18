package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.contact.ContactDetailsPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactFormPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactSteps {
    //pages.
    private HomePage homePage;
    private PageFactory pageFactory;
    private AppLauncher appLauncher;

    //pages Contacts.
    private ContactListPage contactListPage;
    private ContactFormPage contactFormPage;
    private ContactDetailsPage contactDetailsPage;
    private Contact contact;

    /**
     * Click the app launcher and contacts button.
     */
    @When("^I go to Contact home page$")
    public void iGoToContactHomePage() {
        homePage = pageFactory.getHomePage();
        appLauncher = homePage.topMenu.gotToAppLauncher();
        contactListPage = appLauncher.goToContactPage();
    }

    /**
     * Create a new contact.
     */
    @And("^I click on New Contact$")
    public void iClickOnNewContact() {
        contactFormPage = contactListPage.gotToNewButton();
    }

    /**
     * Fill the spaces required to create a new Contact.
     *
     * @param contactList - List of contacts.
     */
    @When("^I fill the Account form name with$")
    public void iFillTheAccountFormNameWith(final List<Contact> contactList) {
        this.contact = contactList.get(0);
        contactDetailsPage = contactFormPage.gotToSaveButton(contact);
    }

    /**
     * Verify if is create a new Contact.
     */
    @Then("^The name should be displayed in detail Page Contact$")
    public void theNameShouldBeDisplayedInDetailPageContact() {
        if(contact.getFirstName().isEmpty()){
            assertEquals(contactDetailsPage.isContactNameDisplayed(), contact.getLastName(), "The contact you get is");
        }
        else{
            assertEquals(contactDetailsPage.isContactNameDisplayed(), contact.getFirstName()+" "+contact.getLastName(), "The contact you get is");
        }

    }
    @When("^I click on Edit button$")
    public void iClickOnEditButton(final List<Contact> contactChanges){
        this.contact = contactChanges.get(0);
        contactDetailsPage.clickOptionEdit(contact);
    }

    @When("^I save the changes made$")
    public void iSaveTheChangesMade(){
        contactDetailsPage.isSaveOfChangeMade();
    }

    @Then("^Shows me the changes made$")
    public void showsMeTheChangesMade() {
        System.out.println(contact.getMobile()+" ------------------");
        System.out.println(contact.getTitle()+" --------------");
        //assertEquals(contactDetailsPage.isMobileChangeDisplayed(),contact.getMobile());
        assertEquals(contactDetailsPage.isTitleChangeDisplayed(), contact.getTitle());
    }


}
