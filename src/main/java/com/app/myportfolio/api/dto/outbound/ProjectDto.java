package com.app.myportfolio.api.dto.outbound;

import com.app.myportfolio.domain.entity.Project;

public class ProjectDto {
    String id;

    String projectName;

    String projectDescription;

    String link;

    String imageLink;

    public ProjectDto(String id, String projectName, String projectDescription, String link, String imageLink) {
        this.id = id;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.link = link;
        this.imageLink = imageLink;
    }

    public static ProjectDto fromDomain(Project project) {
        return new ProjectDto(project.getId(),
                project.getProjectName(),
                project.getProjectDescription(),
                project.getLink().orElse(""),
                project.getImageLink()
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
