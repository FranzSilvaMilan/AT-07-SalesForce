package com.jalasoft.sfdc.ui.pages.quote;

import com.jalasoft.sfdc.entities.Quote;
import com.jalasoft.sfdc.ui.BasePage;

public abstract class QuotesFormPage extends BasePage {

    /**
     * The abstract method that set and save new Quotes.
     * @param quote - class object Quotes.
     * @return new page Classic or Light.
     */
    public abstract QuotesDetailsPage gotToSaveButton(Quote quote);
}
