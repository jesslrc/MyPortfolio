package com.app.myportfolio.api.controller;

import com.app.myportfolio.api.dto.inbound.AddEducationDto;
import com.app.myportfolio.api.dto.inbound.AddProjectDto;
import com.app.myportfolio.api.dto.outbound.ProjectDto;
import com.app.myportfolio.domain.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/add-project")
    String show(ProjectDto projectDto, @CookieValue(value = "session-token", defaultValue = "") String userId) {
        if (Objects.equals(userId, "")) {
            return "redirect:/login?unauthorized=true";
        }

        return "add_project";
    }

    @PostMapping("/add-project")
    String process(AddProjectDto addProjectDto, @CookieValue(value = "session-token") String userId) {
        if(userId != null) {
            projectService.saveProject(addProjectDto, userId);
        }

        return "redirect:/profile/" + userId;
    }
}
