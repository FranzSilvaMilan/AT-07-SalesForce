package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.api.apiClass.APIContact;
import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.contact.*;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import io.restassured.response.Response;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
    private Contact contactAPI;

    private APIContact apiContact;
    private Response response;

    //---------------------------------------------------------------------------------------
    //                                      Create a new Contact
    //---------------------------------------------------------------------------------------

    /**
     * Click the app launcher and contacts button.
     */
    @When("^I go to Contact list page$")
    public void iGoToContactHomePage() {
        homePage = pageFactory.getHomePage();
        appLauncher = homePage.topMenu.gotToAppLauncher();
        contactListPage = appLauncher.goToContactPage();
    }

    /**
     * Create a new contact.
     */
    @And("^I click on New Contact button$")
    public void iClickOnNewContactButton() {
        contactFormPage = contactListPage.gotToNewButton();
    }

    /**
     * Fill the spaces required to create a new Contact.
     */
    @When("^I create the Contact with the following information$")
    public void iCreateTheContactWithTheFollowingInformation(final List<Contact> contactList) {
        this.contact = contactList.get(0);
        contact.updateContactFirstName();
        apiContact = new APIContact(contact);
        contactDetailsPage = contactFormPage.gotToSaveButton(contact);
        contactDetailsPage.getIdUrlCurrent(contact);
    }

    /**
     * Verify if is create a new Contact.
     * the Contact information should be displayed in Contact Details page
     */
    @Then("^the Contact information should be displayed in Contact Details page$")
    public void theContactInformationShouldBeDisplayedInContactDetailsPage() {
        if (contact.getFirstName().isEmpty()) {
            assertEquals(contactDetailsPage.isContactNameDisplayed(), contact.getLastName(), "The contact you get is");
        } else {
            assertEquals(contactDetailsPage.isContactNameDisplayed(), contact.getFirstName() + " " + contact.getLastName(), "The contact you get is");
        }
        assertTrue(contactDetailsPage.isTitleChangeDisplayed(contact), "The title is displayed");
        assertTrue(contactDetailsPage.isMobileChangeDisplayed(contact), "The number mobile is displayed");
    }

    //----------------------------------------------------------------------------------------
    //                                      Edit Contact
    //----------------------------------------------------------------------------------------

    /**
     * Create contact with API.
     * @param listContact
     */
    @And("^I have a Contact with the following information:$")
    public void iHaveAContactWithFollowingInformation(List<Contact> listContact) {
        contact = listContact.get(0);
        contact.updateContactFirstName();
        apiContact = new APIContact(contact);
        apiContact.createSObjectRecord();
    }

    @And("^I select the Contact in Contact list page$")
    public void iSelectTheContactInContactListPage() {
        contactDetailsPage = contactListPage.clickContactOnList(contact);
    }

    @And("^I click on Edit Contact button$")
    public void iClickOnEditContactButton(){
        contactDetailsPage.clickEditButton();
    }

    @And("^I edit the Contact with the following information$")
    public void iEditTheContactWithTheFollowingInformation(final List<Contact> contactChanges) {
        this.contact = contactChanges.get(0);
        contactDetailsPage.setNewChangesToContact(contact);
    }

    //-----------------------------------------------------------------------------------------
    //                                      Deleted Contact
    //-----------------------------------------------------------------------------------------

    @And("^I click on Delete Contact button$")
    public void iClickOnDeleteContactButton() {
        contactDetailsPage.clickDeletedButton();
    }

    @Then("^the Contact should be removed in Contact list page$")
    public void theContactShouldBeRemovedInContactListPage() {
        assertEquals(contactListPage.isContatcNotDisplayed(contact), false, "The contacts is removed ");
    }

    //----------------------------------------------------------------------------------------------------
    //                                              Validate for API
    //----------------------------------------------------------------------------------------------------
    /**
     * Verify contact with API
     * the Contact should be created
     */
    @And("^the Contact should be created$")
    public void theContactShouldBeCreated() {
        Contact contact = apiContact.getContactValuesByAPI();
        assertEquals(contact.getFirstName(),contact.getFirstName());
        assertEquals(contact.getLastName(),contact.getLastName());
        assertEquals(contact.getTitle(),contact.getTitle());
        assertEquals(contact.getMobile(),contact.getMobile());
    }


    /**
     * Verify contact with API
     * the Contact should be edit
     */
    @And("^the Contact should be edited$")
    public void theContactShouldBeEdited(){
        Contact contactSpected = apiContact.getContactValuesByAPI();
        assertEquals(contactSpected.getFirstName(),contact.getFirstName());
        assertEquals(contactSpected.getLastName(),contact.getLastName());
        assertEquals(contactSpected.getTitle(),contact.getTitle());
        assertEquals(contactSpected.getMobile(),contact.getMobile());
    }


    /**
     * Verify contact with API
     * the Contact should be removed
     */
    @And("^the Contact should be removed$")
    public void theContactShouldBeRemoved(){
        final String deleteEntity="The requested resource does not exist";
        response = apiContact.deleteAccountByAPI();
        assertTrue(response.asString().contains(deleteEntity), "should be return :");
    }

    //****************************************************************
    //          Hooks for @create Account api scenarios
    //****************************************************************
    @After(value = "@deleteContactSteps", order = 999)
    public void afterContactScenario() {
        apiContact.deleteSObjectRecord();
    }
}
