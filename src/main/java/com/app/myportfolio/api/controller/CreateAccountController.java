package com.app.myportfolio.api.controller;

import com.app.myportfolio.api.dto.inbound.CreateAccountDto;
import com.app.myportfolio.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateAccountController {

    private final AccountService accountService;

    @Autowired
    public CreateAccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/create-account")
    String show(CreateAccountDto createAccountDto) {
        return "create_account";
    }

    @PostMapping("/create-account")
    String process(CreateAccountDto createAccountDto) {
        accountService.createUser(createAccountDto);

        return "create_account";
    }
}
