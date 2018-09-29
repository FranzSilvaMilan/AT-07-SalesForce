package com.jalasoft.sfdc.api.apiClass;

import com.jalasoft.sfdc.api.APIManager;
import com.jalasoft.sfdc.entities.Account;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.ACCOUNT;
import static com.jalasoft.sfdc.constants.SFDCConstants.ACCOUNT_EMPLOYEES;
import static com.jalasoft.sfdc.constants.SFDCConstants.ACCOUNT_NAME;
import static com.jalasoft.sfdc.constants.SFDCConstants.ACCOUNT_FAX;
import static com.jalasoft.sfdc.constants.SFDCConstants.ACCOUNT_PHONE;
import static com.jalasoft.sfdc.constants.SFDCConstants.ACCOUNT_SICCODE;
import static com.jalasoft.sfdc.constants.SFDCConstants.ACCOUNT_WEB;
import static com.jalasoft.sfdc.constants.SFDCConstants.ID;

/**
 * CLAS API ACCOUNT
 */
public class APIAccount extends APIBase{
    private final Account account;
    private Account accountApi;

    /**
     * constructor APIAccount
     * @param account
     */
    public APIAccount(Account account) {
            this.account = account;
            this.accountApi = new Account();
            fieldsMap = covertEntityToMap();
            apiSObjectName = ACCOUNT;
    }

    /**
     * convert json to map
     *
     * @return
     */
    @Override
    protected Map<String, Object> covertEntityToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("Name", account.getName());
        map.put("Phone", account.getPhone());
        map.put("Website", account.getWeb());
        map.put("Fax", account.getFax());
        map.put("NumberOfEmployees", account.getEmployees());
        map.put("Sic", account.getSicCode());
        map.put("AccountNumber",account.getNumber());
        return map;
    }

    @Override
    protected void setAPIObjectId() {
        account.setId(response.jsonPath().get(ID).toString());
    }

    @Override
    protected String getAPIObjectId() {
        return account.getId();
    }

    /**
     * get values of json
     * @return
     */
    public Account getAccountValuesByAPI() {
        response = APIManager.getInstance().get("/sobjects/Account/" + account.getId());
        accountApi.setName(response.jsonPath().get(ACCOUNT_NAME).toString());
        accountApi.setFax(response.jsonPath().get(ACCOUNT_FAX).toString());
        accountApi.setWeb(response.jsonPath().get(ACCOUNT_WEB).toString());
        accountApi.setEmployees(response.jsonPath().get(ACCOUNT_EMPLOYEES).toString());
        accountApi.setSicCode(response.jsonPath().get(ACCOUNT_SICCODE).toString());
        accountApi.setPhone(response.jsonPath().get(ACCOUNT_PHONE).toString());
        return accountApi;
    }

}
