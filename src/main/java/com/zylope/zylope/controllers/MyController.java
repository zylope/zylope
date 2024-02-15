package com.zylope.zylope.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @GetMapping("/")
    public String hello() {
        return "hello"; // Assuming there's a Thymeleaf template named "hello.html"
    }

    @PostMapping("/submitForm")
    @ResponseBody
    public String submitForm(String formData) {
        // Process form data
        return "Form submitted successfully!";
    }
}
