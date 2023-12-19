package com.app.myportfolio.domain.repository;

import com.app.myportfolio.domain.entity.AccountSkill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountSkillRepository extends CrudRepository<AccountSkill, AccountSkill.AccountSkillId> {

    List<AccountSkill> findByIdAccountId(String accountId);
}
