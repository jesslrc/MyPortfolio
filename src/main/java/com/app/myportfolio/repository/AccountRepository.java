package com.app.myportfolio.repository;

import com.app.myportfolio.bean.CreateAccount;
import com.app.myportfolio.dao.mapper.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

    public void saveAccount(CreateAccount createAccount) {
        Account account = new Account(createAccount.getFirstName(), createAccount.getLastName(), createAccount.getEmail(), createAccount.getPassword());
        //TODO persist account in DB
    }

}
