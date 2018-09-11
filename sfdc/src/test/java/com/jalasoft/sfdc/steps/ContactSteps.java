package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.contact.ContactDetailsPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactFormPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactSteps {

    private HomePage homePage;
    private PageFactory pageFactory;
    private AppLauncher appLauncher;
    private ContactListPage contactListPage;
    private ContactFormPage contactFormPage;
    private ContactDetailsPage contactDetailsPage;

 /*   @When("^I click in the option AppLuncher$")//^I goes to "([^"]*)" home page$
    public void iClickInTheOptionAppLuncher() throws Throwable {
        homePage = pageFactory.getHomePage();
        appLuncher = homePage.topMenu.clickAllLuncher();
        contactListPage = appLuncher.clickContactButton();
        //contactFormPage = contactListPage.clickButtonNew();
        //homePage = PageFactory.
        // Write code here that turns the phrase above into concrete actions

    }*/

   /* @When("^I click in New Button of Contatct$")
    public void iClickInNewButtonOfContatct() throws Throwable {
        contactFormPage = contactListPage.clickButtonNew();
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }*/


//-----------------------------------------------------------------------------------
    @When("^I goes to \"([^\"]*)\" home page$")
    public void iGoesToHomePage(String arg0) throws Throwable {
        homePage = pageFactory.getHomePage();
        appLauncher = homePage.topMenu.gotToAppLauncher();
        contactListPage = appLauncher.goToContactPage();
    }

    @When("^I create a new contact \"([^\"]*)\"$")
    public void iCreateANewContact(String newContact){
        contactFormPage = contactListPage.gotToNewButton();
        contactDetailsPage = contactFormPage.gotToSaveButton(newContact);
    }

    @Then("^verify if is create a new contact$")
    public void verifyIfIsCreateANewContact() throws Throwable {
        throw new PendingException();
    }
}
