package com.app.myportfolio.domain.repository;

import com.app.myportfolio.domain.entity.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkillRepository extends CrudRepository<Skill, String> {
    List<Skill> findAllByIdIn(List<String> skillIds);
}
