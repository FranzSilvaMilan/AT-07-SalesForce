package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.contact.ContactDetailsPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactFormPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
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
     * //@param newContact - Last name of the new contact.
     */
    @When("^I fill the Account form name with$")
    public void iFillTheAccountFormNameWith(final List<Contact> contactList) {
        this.contact = contactList.get(0);
        System.out.println(contact.getLastName()+" ----++++++++++++---- "+contact.getFirstName());
        contactDetailsPage = contactFormPage.gotToSaveButton(contact);
    }
    /*
    @When("^I fill the Account form name with: \"([^\"]*)\"$")
    public void iFillTheAccountFormNameWith(String newContact) {
        contactDetailsPage = contactFormPage.gotToSaveButton(newContact);
    }*/


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
}
