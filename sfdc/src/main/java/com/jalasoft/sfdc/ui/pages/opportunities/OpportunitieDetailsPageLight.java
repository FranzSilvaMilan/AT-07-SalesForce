package com.jalasoft.sfdc.ui.pages.opportunities;

import com.jalasoft.sfdc.entities.Opportunitie;
import com.jalasoft.sfdc.ui.pages.quote.QuotesFormPage;

public class OpportunitieDetailsPageLight extends OpportunitieDetailsPage{
    @Override
    public boolean isChangeDisplayed(Opportunitie opportunitie) {
        return false;
    }

    @Override
    public QuotesFormPage isNewQuoteSelect() {
        return null;
    }

    @Override
    public void getIdOpportunity(Opportunitie opportunitie) {

    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
