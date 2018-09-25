package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.api.apiClass.APIContact;
import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.contact.*;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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
        if (contact.getFirstName().isEmpty()) {
            assertEquals(contactDetailsPage.isContactNameDisplayed(), contact.getLastName(), "The contact you get is");
        } else {
            assertEquals(contactDetailsPage.isContactNameDisplayed(), contact.getFirstName() + " " + contact.getLastName(), "The contact you get is");
        }
    }

    /**
     * Click on edit button and set new fields.
     *
     * @param contactChanges - Properties to change a contact
     */
    @When("^I Edit Contact with$")
    public void iEditContactWith(final List<Contact> contactChanges) {
        this.contact = contactChanges.get(0);
        contactDetailsPage.clickOptionEditButton(contact);
    }

    /**
     * You can save the changes made by clicking on the save button.
     */
    @When("^I save the changes made$")
    public void iSaveTheChangesMade() {
        contactDetailsPage.isSaveOfChangeMade();
    }

    /**
     * You can check the changes made.
     */
    @Then("^Shows me the changes made$")
    public void showsMeTheChangesMade() {
        assertTrue(contactDetailsPage.isNameChangeDisplayed(contact));
        assertTrue(contactDetailsPage.isTitleChangeDisplayed(contact));
        assertTrue(contactDetailsPage.isMobileChangeDisplayed(contact));
    }

    /**
     * Click on the delete button.
     */
    @When("^I click on option Delete Contact$")
    public void iClickOnOptionDeletContact() {
        contactDetailsPage.clickOptionDelet();
    }

    /**
     * Remove the contact created.
     */
    @Then("^Verified that the contact has been removed$")
    public void verifiedThatTheContactHasBeenRemoved() {
        assertEquals(contactListPage.isContatcNotDisplayed(contact), false);
    }

    //----------------------------------------------------------------------------------------------------

    /**
     * Create contact with API.
     * @param listContact
     */
    @And("^I create by API new Contact with following information:$")
    public void iCreateByAPINewAccountWithFollowingInformation(List<Contact> listContact) {
        apiContact = new APIContact(listContact.get(0));
        contact = listContact.get(0);
        apiContact.createSObjectRecord();
    }

    /**
     * Verify contact with API
     */
    @Then("^name should be displayed in detail Page Contact$")
    public void nameShouldBeDisplayedInDetailPageAccount() {
        Contact contactSpected = apiContact.getContactValuesByAPI();
        assertEquals(contactSpected.getFirstName(),contact.getFirstName());
        assertEquals(contactSpected.getLastName(),contact.getLastName());
        assertEquals(contactSpected.getTitle(),contact.getTitle());
        assertEquals(contactSpected.getMobile(),contact.getMobile());
    }

    /**
     * Verify that form AS a contact can be edit.
     * @param contactEdit - attributes of a contact for edit.
     */
    @When("^I edit the Contact with the following information:$")
    public void iEditTheContactWithTheFollowingInformation(final List<Contact> contactEdit) {
        this.contactAPI = contactEdit.get(0);
        contactDetailsPage = contactListPage.clickContactOnList(contact);
        contactDetailsPage.clickOptionEditButton(contactAPI);
        contactDetailsPage.isSaveOfChangeMade();
    }

    //****************************************************************
    //Hooks for @create Account api scenarios
    //****************************************************************
    @After(value = "@deleteContactAfter", order = 999)
    public void afterLoginScenario() {
        apiContact.deleteSObjectRecord();
    }
}
