package com.jalasoft.sfdc.entities;

import java.util.ArrayList;
import java.util.List;

public class Quote {
    private String quoteName = "";
    private String price = "";
    private String quantity = "";
    private List<Product> productList;
    public Quote(){
        productList = new ArrayList<>();
    }
    /**
     * Gets the quote Name.
     * @return the current quote quote Name.
     */
    public String getQuoteName() {
        return quoteName;
    }

    /**
     * Sets the quote name.
     * @param quoteName quote name to set.
     */
    public void setQuoteName(String quoteName) {
        this.quoteName = quoteName;
    }

    /**
     * Gets the quote price.
     * @return the current quote price.
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets the quote price.
     * @param price quote price to set.
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Gets the quote quantity.
     * @return the current quote quantity.
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Sets the quote quantity.
     * @param quantity quote quantity to set.
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void addQuoteLineItem(Product product) {
        productList.add(product);
    }
}
