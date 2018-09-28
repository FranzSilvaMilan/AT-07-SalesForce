package com.jalasoft.sfdc.api.apiClass;

import com.jalasoft.sfdc.api.APIManager;
import com.jalasoft.sfdc.entities.Opportunitie;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.ID;
import static com.jalasoft.sfdc.constants.SFDCConstants.OPPORTUNITY;
import static com.jalasoft.sfdc.constants.SFDCConstants.OPPY_ACCOUNT_ID;
import static com.jalasoft.sfdc.constants.SFDCConstants.OPPY_CLOSE_DATE;
import static com.jalasoft.sfdc.constants.SFDCConstants.OPPY_NAME;
import static com.jalasoft.sfdc.constants.SFDCConstants.OPPY_STAGE;


public class APIOppy extends APIBase {
  private final Opportunitie oppy;
  private Opportunitie oppyApi;

  public APIOppy(Opportunitie oppy) {
    this.oppy = oppy;
    oppyApi = new Opportunitie();
    fieldsMap = covertEntityToMap();
    apiSObjectName = OPPORTUNITY;
  }

  /**
   * <p>This method converts the </p>
   *
   * @return
   */
  @Override
  protected Map<String, Object> covertEntityToMap() {
    Map<String, Object> oppyMap = new HashMap<>();
    oppyMap.put("Name", oppy.getName());
    oppyMap.put("StageName", oppy.getStage());
    oppyMap.put("CloseDate", oppy.getCloseDate());
    return oppyMap;
  }


  @Override
  protected void setAPIObjectId() {
    oppy.setId(response.jsonPath().get(ID).toString());
  }

  @Override
  public String getAPIObjectId() {
    return oppy.getId();
  }

  public Opportunitie getOppyValuesByAPI() {
    response = APIManager.getInstance().get("/sobjects/"+OPPORTUNITY+"/" + oppy.getId());
    oppyApi.setName(response.jsonPath().get(OPPY_NAME).toString());
    //oppyApi.setAccountId(response.jsonPath().get(OPPY_ACCOUNT_ID).toString());
    oppyApi.setStage(response.jsonPath().get(OPPY_STAGE).toString());
    oppyApi.setCloseDate(response.jsonPath().get(OPPY_CLOSE_DATE).toString());
    return oppyApi;
  }
}
