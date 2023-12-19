package com.app.myportfolio.domain.repository;

import com.app.myportfolio.domain.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, String> {

    Optional<Account> findByEmailAndPassword(String email, String password);
}