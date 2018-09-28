package com.jalasoft.sfdc.ui.pages.opportunities;

import com.jalasoft.sfdc.entities.Opportunitie;
import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.quote.QuotesFormPage;

public abstract class OpportunitieDetailsPage extends BasePage {

    public abstract boolean isChangeDisplayed(Opportunitie opportunitie);
    public abstract QuotesFormPage isNewQuoteSelect();
    public abstract void getIdOpportunity(Opportunitie opportunitie);
}
