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
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listPage(Model model) {
        // Fetch all performances and pass them to the model
        model.addAttribute("performanceList", performanceService.getAllPerformances());
        return "performance/list";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String viewPage(@PathVariable Integer id, Model model) {
        // Fetch performance details by ID and pass them to the model
        PerformanceVO performance = performanceService.getPerformanceById(id);
        if (performance == null) {
            // Redirect if the performance doesn't exist
            return "redirect:/performance/list";
        }
        model.addAttribute("performance", performance);
        return "performance/view";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String writePage() {
        // Show the write form
        return "performance/write";
    }

    @RequestMapping(value = "/write_ok", method = RequestMethod.POST)
    public String writeOkPage(HttpServletRequest request, Model model) {
        // Handle file upload and form submission
        FileUpload fileUpload = new FileUpload();
        PerformanceVO performance = fileUpload.uploadFile(request);

        if (performance == null) {
            // Handle failure in file upload or invalid input
            model.addAttribute("error", "File upload failed or invalid input detected.");
            return "performance/write";
        }

        // Save the performance details in the database
        performanceService.addPerformance(performance);
        // Redirect to the confirmation page
        model.addAttribute("performance", performance); // Pass the saved performance
        return "performance/write_ok";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deletePerformance(@PathVariable Integer id) {
        // Delete the performance by ID
        performanceService.deletePerformanceById(id);
        return "redirect:/performance/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPage(@PathVariable Integer id, Model model) {
        // Fetch the performance details for editing
        PerformanceVO performance = performanceService.getPerformanceById(id);
        if (performance == null) {
            // Redirect if the performance doesn't exist
            return "redirect:/performance/list";
        }
        model.addAttribute("performance", performance);
        return "performance/edit";
    }

    @RequestMapping(value = "/edit_ok", method = RequestMethod.POST)
    public String editOkPage(HttpServletRequest request, Model model) {
        // Handle file upload and form submission for edit
        FileUpload fileUpload = new FileUpload();
        PerformanceVO performance = fileUpload.uploadFile(request);

        if (performance == null) {
            // Handle failure in file upload or invalid input
            model.addAttribute("error", "File upload failed or invalid input detected.");
            return "performance/edit";
        }

        // Update the performance details in the database
        performanceService.updatePerformance(performance);
        return "redirect:/performance/list";
    }
}