package com.app.myportfolio.api.dto.outbound;

import com.app.myportfolio.domain.entity.Account;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class AccountDto {
    String id;
    String firstName;

    String lastName;

    String email;

    String phone;

    String about;

    public AccountDto(String id, String firstName, String lastName, String email, String phone, String about) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.about = about;
    }

    public static AccountDto fromDomain(Account account) {
        return new AccountDto(account.getId(), account.getFirstName(), account.getLastName(),
                account.getEmail(), account.getPhone(), account.getAbout());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
