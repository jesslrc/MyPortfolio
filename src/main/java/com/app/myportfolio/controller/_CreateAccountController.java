package com.app.myportfolio.controller;

import com.app.myportfolio.bean.CreateAccount;
import com.app.myportfolio.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class _CreateAccountController {

    AccountService accountService;

    @Autowired
    public _CreateAccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/create-account")
    String show(CreateAccount createAccount) {
        return "create_account";
    }

    @PostMapping("/create-account")
    String process(CreateAccount createAccount) {
        accountService.createUser(createAccount);

        return "create_account";
    }
}
