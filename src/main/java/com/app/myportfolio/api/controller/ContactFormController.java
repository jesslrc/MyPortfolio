package com.app.myportfolio.api.controller;

import com.app.myportfolio.api.dto.inbound.ContactForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactFormController {

    //TODO handle contact fields
    @GetMapping("/contact-me")
    String show(ContactForm contactForm) {
        return "contact_form";
    }
}
