package com.jalasoft.sfdc.ui.pages.quote;

import com.jalasoft.sfdc.entities.Quote;
import com.jalasoft.sfdc.entities.QuoteLineItem;
import com.jalasoft.sfdc.ui.BasePage;

public abstract class QuoteItemPage extends BasePage {

    public abstract QuotesDetailsPage isClickSaveItemButton(QuoteLineItem quote);
}
