package com.app.myportfolio.domain.service;

import com.app.myportfolio.api.dto.UpdateAccountDto;
import com.app.myportfolio.api.dto.inbound.CreateAccountDto;
import com.app.myportfolio.api.dto.inbound.LoginDto;
import com.app.myportfolio.domain.entity.Account;
import com.app.myportfolio.domain.exception.IncorrectCredentialsException;
import com.app.myportfolio.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createUser(CreateAccountDto createAccountDto) {

        Account account = new Account(
                UUID.randomUUID().toString(),
                createAccountDto.getFirstName(),
                createAccountDto.getLastName(),
                createAccountDto.getEmail(),
                createAccountDto.getPassword(),
                "",
                ""
        );
        accountRepository.save(account);
    }

    public void updateUser(UpdateAccountDto updateAccountDto) {
        accountRepository.findById(updateAccountDto.getId()).map(account -> {
            account.setFirstName(updateAccountDto.getFirstName());
            account.setLastName(updateAccountDto.getLastName());
            account.setEmail(updateAccountDto.getEmail());
            account.setPhone(updateAccountDto.getPhone());
            account.setAbout(updateAccountDto.getAbout());
            return account;
        }).ifPresent(accountRepository::save);
        //TODO maybe this could throw an exception on account not found
    }

    public String login(LoginDto loginDto) throws IncorrectCredentialsException {

        if(loginDto.getEmail() == null || loginDto.getEmail().isEmpty()) {
            throw new RuntimeException("Email");
        }
        if(loginDto.getPassword() == null || loginDto.getPassword().isEmpty()) {
            throw new RuntimeException("Password");
        }

        Optional<Account> result = accountRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        if (result.isPresent()) {
            //proceed with login
            System.out.println("Login successful");

            return result.map(Account::getId).get();
        } else {
            //incorrect email or password, throw exception
            System.out.println("Login unsuccessful");
            throw new IncorrectCredentialsException();
        }
    }

    public Optional<Account> findAccountByUserId(String userId) {
        return accountRepository.findById(userId);
    }
}
