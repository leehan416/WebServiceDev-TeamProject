package com.team.performance.controller;

import com.team.performance.VO.PerformanceVO;
import com.team.performance.service.PerformanceService;
import com.team.performance.util.FileUpload;
import com.team.user.VO.UserVO;
import com.team.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequestMapping(value = "/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @Autowired
    private UserService userService;




    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String viewPage(@PathVariable Integer id, Model model) {
        PerformanceVO performance = performanceService.getPerformanceById(id);
        if (performance == null) return "redirect:/performance/list";

        model.addAttribute("performance", performance);
        return "performance/view";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String writePage(@SessionAttribute(value = "login") UserVO userVO) {
        UserVO vo = userService.getUserById(userVO.getId());

        if (vo.checkAuth_manager())
            return "performance/write";

        else return "redirect:/";
    }

    @RequestMapping(value = "/write_ok", method = RequestMethod.POST)
    public String writeOkPage(HttpServletRequest request, Model model) {
        FileUpload fileUpload = new FileUpload();
        PerformanceVO performance = fileUpload.uploadFile(request);

        //  error
        if (performance == null) return "redirect:/";

        performanceService.addPerformance(performance);
        model.addAttribute("performance", performance);
        return "redirect:/";

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deletePerformance(@SessionAttribute(value = "login") UserVO vo, @PathVariable Integer id) {

        if (vo.checkAuth_manager())
            performanceService.deletePerformanceById(id);

        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPage(@SessionAttribute(value = "login") UserVO vo, @PathVariable Integer id, Model model) {
        if (!vo.checkAuth_manager()) {
            return "redirect:/performance/view/" + id;
        }
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
        PerformanceVO existingPerformance = performanceService.getPerformanceById(updatedPerformance.getId());

        // error checks
        if (existingPerformance == null) {
            model.addAttribute("error", "File upload failed or invalid input detected.");
            return "performance/edit";
        }

        // Update fields if a new file is uploaded, otherwise keep the existing file
        if (updatedPerformance.getPosterFile() != null)
            existingPerformance.setPosterFile(updatedPerformance.getPosterFile());

        existingPerformance.setTitle(updatedPerformance.getTitle());
        existingPerformance.setCurrentNum(updatedPerformance.getCurrentNum());
        existingPerformance.setMaxNum(updatedPerformance.getMaxNum());
        existingPerformance.setPerformanceDate(updatedPerformance.getPerformanceDate());
        existingPerformance.setContent(updatedPerformance.getContent());

        try {
            performanceService.updatePerformance(existingPerformance);
            model.addAttribute("performance", existingPerformance);
//            return "performance/edit_ok";
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while updating the performance. Please try again.");
            e.printStackTrace();
            return "performance/edit";
        }
    }
}