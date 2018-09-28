package com.jalasoft.sfdc.entities;

import java.util.List;

public class Opportunitie {
    private String name;
    private String closeDate;
    private String stage;
    private String accountId;
    private List<Quote> quoteList;
    private String id;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    private String accountName;

    public List<Quote> getQuoteList() {
        return quoteList;
    }

    public void setQuoteList(List<Quote> quoteList) {
        this.quoteList = quoteList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    /**
     * Gets the opportunities name.
     * @return the current opportunities name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the opportunities name.
     * @param name opportunities name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the opportunities close date.
     * @return the current opportunities close date.
     */
    public String getCloseDate() {
        return closeDate;
    }

    /**
     * Sets the opportunities close date.
     * @param closeDate opportunities close date to set.
     */
    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    /**
     * Gets the opportunities stage.
     * @return the current opportunities stage.
     */
    public String getStage() {
        return stage;
    }

    /**
     * Sets the opportunities stage.
     * @param stage opportunities stage to set.
     */
    public void setStage(String stage) {
        this.stage = stage;
    }

    /**
     * Gets the opportunities account Name.
     * @return the current opportunities account Name.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Sets the opportunities account name.
     * @param accountId opportunities account name to set.
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

}
