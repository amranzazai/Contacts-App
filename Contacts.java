package com.example.assignment7;


public class Contacts {
    //Declaring string variables to hold Contact information
    private String emailAddress;
    private String name;
    private String phoneNumber;
    //ID to differentiate each contact
    private int id;


    public String getEmail() {
    //returns contact's email address
        return emailAddress;
    }
    public String getName() {
        //returns contact's name
        return name;
    }
    public String getNumber() {
        //returns contact's phone number
        return phoneNumber;
    }
    public int getId() {
        //returns contact's ID
        return id;
    }
    public void setEmail(String email) {
        //sets contact's email address
        this.emailAddress = email;
    }
    public void setName(String Name) {
        //sets contact's name
        this.name = Name;
    }
    public void setNumber(String number) {
        //sets contact's number
        this.phoneNumber = number;
    }
    public void setId(int ID) {
        //sets contact's id
        this.id = ID;
    }












}
