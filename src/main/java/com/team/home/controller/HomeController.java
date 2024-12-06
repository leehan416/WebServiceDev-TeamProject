package com.team.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
