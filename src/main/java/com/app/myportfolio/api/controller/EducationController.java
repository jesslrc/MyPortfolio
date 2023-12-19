package com.app.myportfolio.api.controller;

import com.app.myportfolio.api.dto.inbound.AddEducationDto;
import com.app.myportfolio.domain.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class EducationController {

    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/add-education")
    String show(AddEducationDto addEducationDto, @CookieValue(value = "session-token", defaultValue = "") String userId) {
        if (Objects.equals(userId, "")) {
            return "redirect:/login?unauthorized=true";
        }

        return "add_education";
    }

    @PostMapping("/add-education")
    String process(AddEducationDto addEducationDto, @CookieValue(value = "session-token") String userId) {
        if(userId != null) {
            educationService.saveEducation(addEducationDto, userId);
        }

        return "redirect:/profile/" + userId;
    }
}
