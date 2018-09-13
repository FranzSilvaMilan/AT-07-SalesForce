package com.jalasoft.sfdc.entities;

/**
 * User class contains the user information.
 *
 * @author Daniel Sandoval
 * @since 9/12/2018
 */
public class Contact {
    private String firstName = "";
    private String lastName = "";
    private String title = "";
    private String departament = "";
    private String phone = "";
    private String homePhone = "";
    private String mobile = "";
    private String otherPhone = "";
    private String fax = "";
    private String email = "";
    private String assistant = "";
    private String assistentPhone = "";

    /**
     * Gets the contact first name.
     * @return the current contact first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the contact first name.
     * @param firstName contact first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the contact last name.
     * @return the current contact last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the contact last name.
     * @param lastName contact last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the contact title.
     * @return the current contact title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the contact title.
     * @param title contact title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the contact departament.
     * @return the current contact departament.
     */
    public String getDepartament() {
        return departament;
    }

    /**
     * Sets the conatct departament.
     * @param departament contact departament to set.
     */
    public void setDepartament(String departament) {
        this.departament = departament;
    }

    /**
     * Gets the contact phone.
     * @return the current contact phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the contact phone.
     * @param phone contact phone to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the contact home phone.
     * @return the current contact home phone.
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * Sets the contact home phone.
     * @param homePhone contact home phone to set.
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * Gets the contact mobile.
     * @return the current contact mobile.
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the contact mobile.
     * @param mobile contact mobile to set.
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the contact other phone.
     * @return the current contact other phone.
     */
    public String getOtherPhone() {
        return otherPhone;
    }

    /**
     * Sets the contact other phone.
     * @param otherPhone contact other phone to set.
     */
    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    /**
     * Gets the contact fax.
     * @return the current contact fax.
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the contact fax.
     * @param fax contact faxe to set.
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * Gets the contact email.
     * @return the current contact email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the contact email.
     * @param email contact email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the contact assistent.
     * @return the current contact assistent.
     */
    public String getAssistant() {
        return assistant;
    }

    /**
     * Sets the contact assistant.
     * @param assistant contact assistant to set.
     */
    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    /**
     * Gets the contact assistent phone.
     * @return the current contact assistent phone.
     */
    public String getAssistentPhone() {
        return assistentPhone;
    }

    /**
     * Sets the contact assistent phone.
     * @param assistentPhone contact assistent phone to set.
     */
    public void setAssistentPhone(String assistentPhone) {
        this.assistentPhone = assistentPhone;
    }
}