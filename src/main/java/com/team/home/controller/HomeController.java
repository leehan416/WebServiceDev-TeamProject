package com.team.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// page controller
@Controller
public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listPage() {
        return "list";
    }

    @RequestMapping(value = "/view/{id}")
    public String viewPage(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id.toString());
        return "view";
    }

    @RequestMapping(value = "/write")
    public String viewPage() {
        return "write";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }




}
