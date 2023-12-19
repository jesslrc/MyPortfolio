package com.app.myportfolio.domain.service;

import com.app.myportfolio.api.dto.inbound.AddProjectDto;
import com.app.myportfolio.domain.entity.Education;
import com.app.myportfolio.domain.entity.Project;
import com.app.myportfolio.domain.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    ProjectRepository projectRepository;
    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findProjectsByUserId(String userId) {
        return projectRepository.findByAccountId(userId);
    }

    public void saveProject(AddProjectDto addProjectDto, String userId) {
        Project project = new Project(addProjectDto, userId);
        projectRepository.save(project);
    }
}
