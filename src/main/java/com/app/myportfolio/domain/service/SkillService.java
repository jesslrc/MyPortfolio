package com.app.myportfolio.domain.service;

import com.app.myportfolio.api.dto.inbound.AddSkillDto;
import com.app.myportfolio.domain.entity.AccountSkill;
import com.app.myportfolio.domain.entity.Skill;
import com.app.myportfolio.domain.repository.AccountSkillRepository;
import com.app.myportfolio.domain.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {
    private final SkillRepository skillRepository;
    private final AccountSkillRepository accountSkillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository, AccountSkillRepository accountSkillRepository) {
        this.skillRepository = skillRepository;
        this.accountSkillRepository = accountSkillRepository;
    }

    public void addSkillToAccount(AddSkillDto addSkillDto) {
        AccountSkill accountSkill = new AccountSkill(addSkillDto.getAccountId(), addSkillDto.getSkillId());
        accountSkillRepository.save(accountSkill);
    }

    public List<Skill> findAll() {
        List<Skill> skills = new ArrayList<>();
        skillRepository.findAll().forEach(skills::add);
        return skills;
    }

    public List<Skill> findByAccountId(String accountId) {
        List<String> skillIds = accountSkillRepository.findByIdAccountId(accountId)
                .stream()
                .map(s -> s.getId().getSkillId())
                .toList();
        return skillRepository.findAllByIdIn(skillIds);
    }
}
