package com.team.performance.controller;

import com.team.performance.VO.PerformanceVO;
import com.team.performance.service.PerformanceService;
import com.team.performance.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

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
    public String writeOkPage(HttpServletRequest request) {
        // Use FileUpload class to handle the request
        FileUpload fileUpload = new FileUpload();
        PerformanceVO performance = fileUpload.uploadFile(request);

        if (performance == null) {
            // Log failure and redirect back to the write page
            System.out.println("File upload failed or invalid input detected.");
            return "performance/write";
        }

        // Save the performance details in the database
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