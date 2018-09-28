package com.jalasoft.sfdc.api.apiClass;


import com.jalasoft.sfdc.api.APIManager;
import com.jalasoft.sfdc.entities.Quote;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.ID;
import static com.jalasoft.sfdc.constants.SFDCConstants.QUOTE;
import static com.jalasoft.sfdc.constants.SFDCConstants.QUOTE_ACCOUNT_NAME;
import static com.jalasoft.sfdc.constants.SFDCConstants.QUOTE_NAME;
import static com.jalasoft.sfdc.constants.SFDCConstants.QUOTE_OPORTUNITY_ID;
import static com.jalasoft.sfdc.constants.SFDCConstants.QUOTE_TOTAL_PRICE;


public class APIQuote extends APIBase {
  private final Quote quote;
  private Quote quoteApi;

  public APIQuote(Quote quote) {
    this.quote = quote;
    this.quoteApi = new Quote();
    fieldsMap = covertEntityToMap();
    apiSObjectName = QUOTE;
  }

  @Override
  protected Map<String, Object> covertEntityToMap() {
    Map<String, Object> quoteMap = new HashMap<>();
    quoteMap.put("Name", quote.getQuoteName());
    quoteMap.put("OpportunityId", quote.getOportunityId());
    return quoteMap;
  }

  @Override
  protected void setAPIObjectId() {
    quote.setId(response.jsonPath().get(ID).toString());
  }

  @Override
  protected String getAPIObjectId() {
    System.out.println("quote id: " + quote.getId());
    return quote.getId();
  }

  public Quote getAccountValuesByAPI() {
    response = APIManager.getInstance().get("/sobjects/Quote/" + quoteApi.getId());
    quoteApi.setQuoteName(response.jsonPath().get(QUOTE_NAME).toString());
    quoteApi.setOportunityId(response.jsonPath().get(QUOTE_OPORTUNITY_ID).toString());
    quoteApi.setPrice(response.jsonPath().get(QUOTE_TOTAL_PRICE).toString());
    quoteApi.setAccountName(response.jsonPath().get(QUOTE_ACCOUNT_NAME).toString());
    return quoteApi;
  }
}
