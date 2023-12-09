package com.app.myportfolio.service;

import com.app.myportfolio.bean.CreateAccount;
import com.app.myportfolio.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createUser(CreateAccount createAccount) {
        //TODO validate business rules
        accountRepository.saveAccount(createAccount);
    }
}
