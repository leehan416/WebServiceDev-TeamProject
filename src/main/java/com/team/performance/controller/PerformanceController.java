package com.team.performance.controller;

import com.team.performance.VO.PerformanceVO;
import com.team.performance.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PerformanceController {

    @Autowired
    public PerformanceService performanceService;

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String writePage() {
        return "performance/write";
    }

    @RequestMapping(value = "/write_ok", method = RequestMethod.POST)
    public String writeOkPage(@ModelAttribute PerformanceVO performance) {
        performanceService.addPerformance(performance);
        return "redirect:/performance/list";
    }
}