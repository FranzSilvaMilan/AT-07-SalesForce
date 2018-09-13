package com.jalasoft.sfdc.entities;

/**
 * Product class contains the product information.
 *
 * @author Erik Vargas
 * @since 9/12/2018
 */
public class Product {
    private String productName = "";
    private String productCode = "";
    private String productDescription = "";
    private boolean active;

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
}
