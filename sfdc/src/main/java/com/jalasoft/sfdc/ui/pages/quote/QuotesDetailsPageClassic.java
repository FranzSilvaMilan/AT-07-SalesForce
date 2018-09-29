package com.jalasoft.sfdc.ui.pages.quote;

import com.jalasoft.sfdc.entities.Quote;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuotesDetailsPageClassic extends QuotesDetailsPage {
    @FindBy(xpath = "//input[@title='Add Line Item']")
    private WebElement addLineItemButton;
    @FindBy(xpath = "//div[contains(@id,'ileinner') and contains(text(),'test quote')]")
    private WebElement validateQuotesName;
    @FindBy(xpath = "//div[contains(@id,'TotalPrice_ileinner')]")
    private WebElement validateTotalPrice;//741 * x = 37050

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public QuotesAddProductPage addProduct(){
        driverTools.clickElement(addLineItemButton);
        return new QuotesAddProductPageClassic();
    }

    @Override
    public boolean validateQuotesAndProduct(String price, String quantity) {//741
        String total = driverTools.getElementText(validateTotalPrice).substring(1);
        int totalInt = converterString(total);
        System.out.println("total "+total);
        System.out.println("price "+price);
        System.out.println("quantity int: "+converterString(price)*converterString(quantity));
        System.out.println("total int "+totalInt);
        if(converterString(price)*converterString(quantity) == totalInt){
            return true;
        }
        return false;
    }

    private int converterString(String cadena){
        int valor = Integer.parseInt(cadena);
        return valor;
    }
    //Integer.toString(numEntero);

    public void getIdQuote(Quote quote) {
        String url = driver.getCurrentUrl();
        String[] urlSplit = url.split("/");
        quote.setId(urlSplit[urlSplit.length - 1]);
    }
}
