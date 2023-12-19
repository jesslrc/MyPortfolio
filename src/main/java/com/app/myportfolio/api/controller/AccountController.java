package com.app.myportfolio.api.controller;

import com.app.myportfolio.api.dto.UpdateAccountDto;
import com.app.myportfolio.api.dto.inbound.CreateAccountDto;
import com.app.myportfolio.domain.entity.Account;
import com.app.myportfolio.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
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

    @GetMapping("/profile/{userId}/edit-account")
    String editAccount(@PathVariable(value = "userId") String userId,
                       Model model) {
        Account account = accountService.findAccountByUserId(userId).get();

        UpdateAccountDto updateAccountDto = UpdateAccountDto.fromDomain(account);
        model.addAttribute("updateAccountDto", updateAccountDto);

        return "edit_account";
    }

    @PostMapping("/profile/{userId}/edit-account")
    String updateAccount(@PathVariable(value = "userId") String userId,
                         UpdateAccountDto updateAccountDto){
        updateAccountDto.setId(userId);
        accountService.updateUser(updateAccountDto);

        return "redirect:/profile/" + userId;
    }
}
