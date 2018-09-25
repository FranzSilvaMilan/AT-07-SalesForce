package com.jalasoft.sfdc.ui.pages.opportunities;

import com.jalasoft.sfdc.entities.Opportunitie;
import com.jalasoft.sfdc.ui.BasePage;

public abstract class OpportunitieFormPage extends BasePage {

    public abstract OpportunitieDetailsPage gotToSaveButton(Opportunitie opportunitie);

}
