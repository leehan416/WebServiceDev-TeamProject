package com.team.performance.controller;

import com.team.performance.VO.PerformanceVO;
import com.team.performance.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/performance")
public class PerformanceController {

    @Autowired
    public PerformanceService performanceService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("performanceList", performanceService.getAllPerformances());
        return "performance/list";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String viewPage(@PathVariable Integer id, Model model) {
        PerformanceVO performance = performanceService.getPerformanceById(id);
        if (performance == null) {
            return "redirect:/performance/list";
        }
        model.addAttribute("performance", performance);
        return "performance/view";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String writePage() {
        return "performance/write";
    }

    @RequestMapping(value = "/write_ok", method = RequestMethod.POST)
    public String writeOkPage(@ModelAttribute PerformanceVO performance, Model model) {
        // Validate input fields
        if (performance.getTitle() == null || performance.getTitle().trim().isEmpty()) {
            model.addAttribute("error", "Title is required");
            return "performance/write";
        }

        // Log debug info for troubleshooting
        System.out.println("Performance Data: " + performance);

        // Add performance
        performanceService.addPerformance(performance);
        return "redirect:/performance/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deletePerformance(@PathVariable Integer id) {
        performanceService.deletePerformanceById(id);
        return "redirect:/performance/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPage(@PathVariable Integer id, Model model) {
        PerformanceVO performance = performanceService.getPerformanceById(id);
        if (performance == null) {
            return "redirect:/performance/list";
        }
        model.addAttribute("performance", performance);
        return "performance/edit";
    }

    @RequestMapping(value = "/edit_ok", method = RequestMethod.POST)
    public String editOkPage(@ModelAttribute PerformanceVO performance) {
        performanceService.updatePerformance(performance);
        return "redirect:/performance/list";
    }
}