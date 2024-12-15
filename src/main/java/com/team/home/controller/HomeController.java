package com.team.home.controller;

import com.team.performance.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

    @Autowired
    PerformanceService performanceService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("performanceList", performanceService.getAllPerformances());
        return "performance/list";
    }
}