package com.jalasoft.sfdc.entities;

import java.util.ArrayList;
import java.util.List;

public class Quote {
    private String quoteName;
    private String price;
    private double subTotal;
    private double totalPrice;
    private List<QuoteLineItem> quoteLineItemList;

    private String oportunityId;
    private String id;

    private List<Product> productList;

    public Quote() {
        productList = new ArrayList<>();
        quoteLineItemList =  new ArrayList<>();
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<QuoteLineItem> getQuoteLineItem() {
        return quoteLineItemList;
    }

    public void setQuoteLineItem(List<QuoteLineItem> quoteLineItem) {
        this.quoteLineItemList = quoteLineItem;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    private String accountName;

    public String getOportunityId() {
        return oportunityId;
    }

    public void setOportunityId(String oportunityId) {
        this.oportunityId = oportunityId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }


    /**
     * Gets the quote Name.
     *
     * @return the current quote quote Name.
     */
    public String getQuoteName() {
        return quoteName;
    }

    /**
     * Sets the quote name.
     *
     * @param quoteName quote name to set.
     */
    public void setQuoteName(String quoteName) {
        this.quoteName = quoteName;
    }

    /**
     * Gets the quote price.
     *
     * @return the current quote price.
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets the quote price.
     *
     * @param price quote price to set.
     */
    public void setPrice(String price) {
        this.price = price;
    }


    public void addQuoteLineItem(Product product) {
        productList.add(product);
    }

    public int getTotalPrice() {
        int total =0;
        for(QuoteLineItem product : quoteLineItemList){
            total += Integer.valueOf(product.getQuantity())*Integer.valueOf(product.getSalesPrice());
        }
        return total;
    }
}
