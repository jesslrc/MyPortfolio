package com.app.myportfolio.dao.mapper;

public class Account {
    String firstName;

    String lastName;

    String email;

    String password;

    public Account(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
