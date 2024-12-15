package com.team.performance.controller;

import com.team.performance.VO.PerformanceVO;
import com.team.performance.mapper.PerformanceMapper;
import com.team.performance.service.PerformanceService;
import com.team.user.VO.UserVO;
import com.team.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

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


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String home (@RequestParam String text , Model model){
        model.addAttribute("performanceList", performanceService.getPerformancesByText(text));
        return "performance/search";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String writePage(@SessionAttribute(value = "login") UserVO userVO) {
        UserVO vo = userService.getUserById(userVO.getId());

        if (vo.checkAuth_manager())
            return "performance/write";
        else return "redirect:/";

    }

    @RequestMapping(value = "/write_ok", method = RequestMethod.POST)
    public String writeOkPage(@SessionAttribute(value = "login") UserVO vo, HttpServletRequest request, Model model) {

        PerformanceVO performance = performanceService.uploadFile(request, vo.getId());

        //  error
        if (performance == null) return "redirect:/";

        performanceService.addPerformance(performance);
//        model.addAttribute("performance", performance);
        return "redirect:/";

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deletePerformance(@SessionAttribute(value = "login") UserVO vo, @PathVariable Integer id) {

        Integer writerId = performanceService.getPerformanceById(id).getWriter_id();

        if (vo.checkAuth_admin() || vo.checkAuth_manager() && Objects.equals(vo.getId(), writerId)) {
            performanceService.deletePerformanceById(id);
            return "redirect:/";

        } else return "redirect:/performance/view/" + id;

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPage(@SessionAttribute(value = "login") UserVO vo, @PathVariable Integer id, Model model) {

        //===================
        Integer writerId = performanceService.getPerformanceById(id).getWriter_id();
        System.out.println("pass here");
        if (!Objects.equals(vo.getId(), writerId)) {
            System.out.println("vo id = " + vo.getId() + "writer id = " + writerId);
            return "redirect:/performance/view/" + id;
        }
        //===================


        PerformanceVO performance = performanceService.getPerformanceById(id);
        if (performance == null) {
            return "redirect:/";
        }
        model.addAttribute("performance", performance);
        return "performance/edit";
    }

    @RequestMapping(value = "/edit_ok", method = RequestMethod.POST)
    public String editOkPage(
            @SessionAttribute(value = "login") UserVO vo,
            HttpServletRequest request, Model model) {

        if (!vo.checkAuth_admin() || !vo.checkAuth_manager())
            return "redirect:/";

//        FileUpload fileUpload = new FileUpload();


        PerformanceVO updatedPerformance = performanceService.uploadFile(request, vo.getId());
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
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while updating the performance. Please try again.");
            e.printStackTrace();
            return "performance/edit";
        }
    }
}