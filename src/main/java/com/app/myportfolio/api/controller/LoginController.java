package com.app.myportfolio.api.controller;

import com.app.myportfolio.api.dto.inbound.LoginDto;
import com.app.myportfolio.domain.exception.IncorrectCredentialsException;
import com.app.myportfolio.domain.service.AccountService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;

@Controller
public class LoginController {

    public static final String SESSION_TOKEN = "session-token";
    private final AccountService accountService;

    @Autowired
    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/login")
    String show(LoginDto loginDto, Model model, @RequestParam(value = "unauthorized", defaultValue = "false") boolean isUnauthorized) {
        if (isUnauthorized) {
            model.addAttribute("unauthorized", true);
        }
        return "login";
    }

    @GetMapping("/logout")
    String logout(LoginDto loginDto, Model model, HttpServletResponse response) {
        Cookie cookie = new Cookie(SESSION_TOKEN, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "login";
    }

    @PostMapping("/login")
    String process(LoginDto loginDto, Model model, HttpServletResponse response) {
        try {
            String id = accountService.login(loginDto);
            Cookie sessionCookie = new Cookie(SESSION_TOKEN, id);
            sessionCookie.setMaxAge((int) Duration.ofMinutes(15).toSeconds());

            response.addCookie(sessionCookie);

            return "redirect:/profile/" + id;
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("error", true);
        }

        return "login";
    }
}
