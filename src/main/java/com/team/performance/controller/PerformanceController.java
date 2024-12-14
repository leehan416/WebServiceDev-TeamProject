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
    public String writeOkPage(HttpServletRequest request, Model model) {
        FileUpload fileUpload = new FileUpload();
        PerformanceVO performance = fileUpload.uploadFile(request);

        if (performance == null) {
            model.addAttribute("error", "File upload failed or invalid input detected.");
            return "performance/write";
        }

        performanceService.addPerformance(performance);
        model.addAttribute("performance", performance);
        return "performance/write_ok";
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
    public String editOkPage(HttpServletRequest request, Model model) {
        FileUpload fileUpload = new FileUpload();
        PerformanceVO updatedPerformance = fileUpload.uploadFile(request);

        if (updatedPerformance == null) {
            model.addAttribute("error", "File upload failed or invalid input detected.");
            return "performance/edit";
        }

        PerformanceVO existingPerformance = performanceService.getPerformanceById(updatedPerformance.getId());
        if (existingPerformance == null) {
            model.addAttribute("error", "Performance not found.");
            return "performance/edit";
        }

        // Update fields if a new file is uploaded, otherwise keep the existing file
        if (updatedPerformance.getPosterFile() != null) {
            existingPerformance.setPosterFile(updatedPerformance.getPosterFile());
        }
        existingPerformance.setTitle(updatedPerformance.getTitle());
        existingPerformance.setCurrentNum(updatedPerformance.getCurrentNum());
        existingPerformance.setMaxNum(updatedPerformance.getMaxNum());
        existingPerformance.setPerformanceDate(updatedPerformance.getPerformanceDate());
        existingPerformance.setContent(updatedPerformance.getContent());

        try {
            performanceService.updatePerformance(existingPerformance);
            model.addAttribute("performance", existingPerformance);
            return "performance/edit_ok";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while updating the performance. Please try again.");
            e.printStackTrace();
            return "performance/edit";
        }
    }
}