package com.jalasoft.sfdc.ui.pages.quote;

import com.jalasoft.sfdc.ui.BasePage;

public abstract class QuotesDetailsPage extends BasePage {

    /**
     * The abstract metodh that add Product.
     * @return new page Quotes Classic or Light.
     */
    public abstract QuotesAddProductPage addProduct();

}
