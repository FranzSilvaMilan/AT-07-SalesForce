package com.jalasoft.sfdc.ui.pages.quote;

import com.jalasoft.sfdc.entities.Quote;
import com.jalasoft.sfdc.ui.BasePage;

public abstract class QuotesFormPage extends BasePage {

    public abstract QuotesDetailsPage gotToSaveButton(Quote quote);
}
