package com.model;


public class Users {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private String emailAddress;

    public Users(int _id, String _firstName, String _lastName, String _phone, String _pass, String _email) {
        this.id = _id;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.phone = _phone;
        this.password = _pass;
        this.emailAddress = _email;
    }

    public Users() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


}
