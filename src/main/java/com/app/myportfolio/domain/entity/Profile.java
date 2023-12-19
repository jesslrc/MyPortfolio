package com.app.myportfolio.domain.entity;

import java.util.List;

public class Profile {
    Account account;
    List<Project> projects;
    List<Education> educations;
    List<Skill> skills;

    public Profile(Account account, List<Project> projects, List<Education> educations, List<Skill> skills) {
        this.account = account;
        this.projects = projects;
        this.educations = educations;
        this.skills = skills;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
