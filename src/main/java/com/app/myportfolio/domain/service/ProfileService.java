package com.app.myportfolio.domain.service;

import com.app.myportfolio.domain.entity.*;
import com.app.myportfolio.domain.exception.UnableToFindProfileException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final AccountService accountService;
    private final ProjectService projectService;
    private final EducationService educationService;
    private final SkillService skillService;

    public ProfileService(AccountService accountService, ProjectService projectService, EducationService educationService, SkillService skillService) {
        this.accountService = accountService;
        this.projectService = projectService;
        this.educationService = educationService;
        this.skillService = skillService;
    }

    public Profile findProfileByUserId(String userId) throws UnableToFindProfileException {
        Account account = accountService.findAccountByUserId(userId).orElseThrow(UnableToFindProfileException::new);
        List<Project> projects = projectService.findProjectsByUserId(userId);
        List<Education> educations = educationService.findByUserId(userId);
        List<Skill> skills = skillService.findByAccountId(userId);
        return new Profile(account, projects, educations, skills);
    }
}
