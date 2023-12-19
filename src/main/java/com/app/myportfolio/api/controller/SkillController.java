package com.app.myportfolio.api.controller;

import com.app.myportfolio.api.dto.inbound.AddSkillDto;
import com.app.myportfolio.api.dto.outbound.SkillDto;
import com.app.myportfolio.domain.entity.Skill;
import com.app.myportfolio.domain.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class SkillController {

    private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    private ModelAndView showSkillsView() {
        List<SkillDto> skills = skillService.findAll()
                .stream()
                .map(SkillDto::fromDomain)
                .toList();
        ModelAndView mav = new ModelAndView("add_skill");
        mav.addObject("skills", skills);
        return mav;
    }

    @GetMapping("/add-skill")
    ModelAndView show(AddSkillDto addSkillDto, @CookieValue(value = "session-token", defaultValue = "") String userId) {
        if (Objects.equals(userId, "")) {
            return new ModelAndView("redirect:/login?unauthorized=true");
        }
        return showSkillsView();
    }



    @PostMapping("/add-skill")
    String process(AddSkillDto addSkillDto, @CookieValue(value = "session-token") String userId) {
        addSkillDto.setAccountId(userId);
        skillService.addSkillToAccount(addSkillDto);
        return "redirect:/profile/" + userId;
    }
}
