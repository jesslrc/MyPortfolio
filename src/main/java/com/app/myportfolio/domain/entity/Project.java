package com.app.myportfolio.domain.entity;

import com.app.myportfolio.api.dto.inbound.AddProjectDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Optional;
import java.util.UUID;


@Entity
public class Project {

    @Id
    String id;

    String accountId;

    String projectName;

    String projectDescription;

    String link;

    String imageLink;

    public Project() {}

    public Project(AddProjectDto addProjectDto, String userId) {
        this.id = UUID.randomUUID().toString();
        this.accountId = userId;
        this.projectName = addProjectDto.getProjectName();
        this.projectDescription = addProjectDto.getProjectDescription();
        this.link = addProjectDto.getLink();
        this.imageLink = addProjectDto.getImageLink();
    }


    public String getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public Optional<String> getLink() {
        return Optional.ofNullable(link);
    }

    public String getImageLink() { return imageLink; }
}
