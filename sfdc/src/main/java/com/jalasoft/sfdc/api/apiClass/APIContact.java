package com.jalasoft.sfdc.api.apiClass;

import com.jalasoft.sfdc.api.APIManager;
import com.jalasoft.sfdc.entities.Contact;

import java.util.HashMap;
import java.util.Map;
import io.restassured.response.Response;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;

public class APIContact extends APIBase {
    private final Contact contact;
    private Contact contactApi;

    public APIContact(Contact contact) {
        this.contact = contact;
        this.contactApi = new Contact();
        fieldsMap = covertEntityToMap();
        apiSObjectName = CONTACT;
    }
    /**
     * <p>This method converts the </p>
     *
     * @return
     */
    @Override
    protected Map<String, Object> covertEntityToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("FirstName", contact.getFirstName());
        map.put("LastName", contact.getLastName());
        map.put("HomePhone", contact.getHomePhone());
        map.put("Title", contact.getTitle());
        //map.put("MailingStreet", contact.getMailingStreet());
        //map.put("Phone", contact.getPhone());
        map.put("MobilePhone", contact.getMobile());
        map.put("OtherPhone", contact.getOtherPhone());
        //map.put("LeadSource", contact.getLeadSource());
        //map.put("Languages__c",contact.getLenguaje());
        //map.put("Level__c", contact.getLevel());
        return map;
    }

    public Response deleteAccountByAPI() {
        response = apiManager.delete(ACCOUNT, contact.getId());
        System.out.println("Query response delete: ***************************" + response.asString());
        return response;
    }

    @Override
    protected void setAPIObjectId() {
        contact.setId(response.jsonPath().get(ID).toString());
    }

    @Override
    protected String getAPIObjectId() {
        return contact.getId();
    }

    public Contact getContactValuesByAPI() {
        response = APIManager.getInstance().get("/sobjects/Contact/" + contact.getId());
        contactApi.setFirstName(response.jsonPath().get(CONTACT_FIRST_NAME).toString());
        contactApi.setLastName(response.jsonPath().get(CONTACT_LAST_NAME).toString());
        contactApi.setHomePhone(response.jsonPath().get(CONTACT_HOME_PHONE).toString());
        contactApi.setTitle(response.jsonPath().get(CONTACT_TITLE).toString());
        //contactApi.setMailingStreet(response.jsonPath().get(CONTACT_MAILING_STREET).toString());
        //contactApi.setPhone(response.jsonPath().get(CONTACT_PHONE).toString());
        contactApi.setMobile(response.jsonPath().get(CONTACT_MOBILE).toString());
        contactApi.setOtherPhone(response.jsonPath().get(CONTACT_OTHER_PHONE).toString());
        //contactApi.setLeadSource(response.jsonPath().get(CONTACT_LEAD_SOURCE).toString());
        //contactApi.setLenguaje(response.jsonPath().get(CONTACT_lANGUAJE).toString());
        //contactApi.setLevel(response.jsonPath().get(CONTACT_LEVEL).toString());
        return contactApi;
    }
}
