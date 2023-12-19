package com.app.myportfolio.api.dto.outbound;

import com.app.myportfolio.domain.entity.Profile;
import java.util.List;


public class ProfileDto {
    AccountDto account;
    List<ProjectDto> projects;
    List<EducationDto> educations;
    List<SkillDto> skills;

    public ProfileDto() {
    }

    public ProfileDto(AccountDto account, List<ProjectDto> projects, List<EducationDto> educations, List<SkillDto> skills) {
        this.account = account;
        this.projects = projects;
        this.educations = educations;
        this.skills = skills;
    }

    public static ProfileDto fromDomain(Profile profile) {
        return new ProfileDto(
                AccountDto.fromDomain(profile.getAccount()),
                profile.getProjects().stream().map(ProjectDto::fromDomain).toList(),
                profile.getEducations().stream().map(EducationDto::fromDomain).toList(),
                profile.getSkills().stream().map(SkillDto::fromDomain).toList()
        );
    }

    public AccountDto getAccount() {
        return account;
    }

    public void setAccount(AccountDto account) {
        this.account = account;
    }

    public List<ProjectDto> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDto> projects) {
        this.projects = projects;
    }

    public List<EducationDto> getEducations() {
        return educations;
    }

    public void setEducations(List<EducationDto> educations) {
        this.educations = educations;
    }

    public List<SkillDto> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillDto> skills) {
        this.skills = skills;
    }
}
