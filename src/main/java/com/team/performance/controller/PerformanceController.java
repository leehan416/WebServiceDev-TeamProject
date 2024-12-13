package com.team.performance.controller;

import com.team.performance.VO.PerformanceVO;
import com.team.performance.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PerformanceController {

    @Autowired
    public PerformanceService performanceService;

    @RequestMapping(value = "/write_ok", method = RequestMethod.POST)
    public String writeOk(Model model) {
        // Logic to handle the submission
        return "write_ok"; // Ensure this maps to WEB-INF/views/write_ok.jsp
    }
}