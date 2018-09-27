package com.jalasoft.sfdc.entities;

import java.util.Date;

/**
 * Product class contains the product information.
 *
 * @author Erik Vargas
 * @since 9/12/2018
 */
public class Product {
    private String productName;
    private String productCode;
    private String productDescription;
    private boolean active;
    private String productFamily;

    private String id;
    private String standardPrice;
    private String priceBook;

    /**
     * Gets the product name.
     * @return the current product name.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the product name.
     * @param productName product name to set.
     */
    public void setProductName(final String productName) {
        this.productName = productName;
    }

    /**
     * Gets the product code.
     * @return the current product code.
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Sets the product code.
     * @param productCode product code to set.
     */
    public void setProductCode(final String productCode) {
        this.productCode = productCode;
    }

    /**
     * Gets the active.
     * @return the current active.
     */
    public boolean getActive() {
        return active;
    }

    /**
     * Sets the active.
     * @param active active to set.
     */
    public void setActive(final boolean active) {
        this.active = active;
    }

    /**
     * Gets the product description.
     * @return the current product description.
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * Sets the product description.
     * @param productDescription product description to set.
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * Gets the product family.
     * @return the current product family.
     */
    public String getProductFamily() {
        return productFamily;
    }

    /**
     * Sets the product family.
     * @param productFamily product family to set.
     */
    public void setProductFamily(String productFamily) {
        this.productFamily = productFamily;
    }

    /**
     * Gets the product id.
     * @return the current product id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the product id.
     * @param id product to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the product standard price.
     * @return the current product standard price.
     */
    public String getStandardPrice() {
        return standardPrice;
    }

    /**
     * Sets the product standard Price.
     * @param standardPrice product to set.
     */
    public void setStandardPrice(String standardPrice) {
        this.standardPrice = standardPrice;
    }

    /**
     * Gets the product price book.
     * @return the current product price book.
     */
    public String getPriceBook() {
        return priceBook;
    }

    /**
     * Sets the product priceBook.
     * @param priceBook product to set.
     */
    public void setPriceBook(String priceBook) {
        this.priceBook = priceBook;
    }

    public void updateProductName() {
        Long timeStamp = new Date().getTime();
        this.productName += timeStamp;
    }
}
