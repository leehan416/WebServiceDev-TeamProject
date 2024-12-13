package com.team.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpSession session) {
        // Check if the user is logged in
        if (session.getAttribute("login") == null) {
            return "redirect:/login"; // Redirect to login if not logged in
        }
        return "index"; // Show index page for logged-in users
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpSession session) {
        // If already logged in, redirect to main options page
        if (session.getAttribute("login") != null) {
            return "redirect:/";
        }
        return "user/login/login"; // Login page
    }
}