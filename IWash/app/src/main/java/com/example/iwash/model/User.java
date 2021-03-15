package com.example.iwash.model;

public class User {
    public String phoneNumber;
    public String fullName;
    public String address;
    public String password;

    public User() {
    }

    public User(String phoneNumber, String fullName, String address, String password) {
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.address = address;
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
