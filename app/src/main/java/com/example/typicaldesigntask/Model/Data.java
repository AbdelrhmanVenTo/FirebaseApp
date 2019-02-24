package com.example.typicaldesigntask.Model;

public class Data {
    private String userName;
    private String Email;
    private int phone;
    private String id;
    //private String address;


    public Data() {
    }

    public Data(String userName, String email, int phone) {
        this.userName = userName;
        Email = email;
        this.phone = phone;
        //this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
