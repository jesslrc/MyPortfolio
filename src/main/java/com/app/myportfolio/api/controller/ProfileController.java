package com.app.myportfolio.api.controller;

import com.app.myportfolio.api.dto.outbound.ProfileDto;
import com.app.myportfolio.domain.entity.Profile;
import com.app.myportfolio.domain.exception.UnableToFindProfileException;
import com.app.myportfolio.domain.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class ProfileController {

    private final ProfileService profileService;
    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/profile/{userId}")
    ModelAndView showUserProfile(@PathVariable(value = "userId") String userId,
                                 @CookieValue(value = "session-token", defaultValue = "") String cookieUserId,
                                 Model model) {
        try {
            Profile profile = profileService.findProfileByUserId(userId);
            ProfileDto profileDto = ProfileDto.fromDomain(profile);
            ModelAndView mav = new ModelAndView("profile");
            mav.addObject("profile", profileDto);
            mav.addObject("isOwner", Objects.equals(userId, cookieUserId));
            return mav;

        } catch (UnableToFindProfileException e) {
            model.addAttribute("error", true);
        }
        return new ModelAndView("profile");
    }
}
