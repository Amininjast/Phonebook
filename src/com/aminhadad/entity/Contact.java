package com.aminhadad.entity;

public class Contact extends Entity {
    private String firstName;
    private String lastName;
    private PhoneNumber phoneNumber;

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

    public Contact(){}

    public Contact(int id,String firstName,String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
