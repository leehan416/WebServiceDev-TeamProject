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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Controller
@Slf4j
@RequestMapping(value = "/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String listPerformances(
            @RequestParam(value = "sort", required = false, defaultValue = "latest") String sort,
            Model model) {
        log.info("Listing performances with sort option: {}", sort);

        List<PerformanceVO> performances;
        if ("oldest".equals(sort)) {
            performances = performanceService.getPerformancesSortedByDateAsc();
        } else {
            performances = performanceService.getPerformancesSortedByDateDesc();
        }

        model.addAttribute("performanceList", performances);
        model.addAttribute("sort", sort); // 현재 정렬 상태를 JSP로 전달
        return "performance/list";
    }

    @GetMapping("/view/{id}")
    public String viewPage(@PathVariable Integer id, Model model) {
        PerformanceVO performance = performanceService.getPerformanceById(id);
        if (performance == null) {
            log.warn("Performance not found with ID: {}", id);
            return "redirect:/performance/list";
        }
        model.addAttribute("performance", performance);
        return "performance/view";
    }

    @GetMapping("/write")
    public String writePage(@SessionAttribute(value = "login") UserVO userVO) {
        UserVO vo = userService.getUserById(userVO.getId());
        if (vo.checkAuth_manager()) {
            return "performance/write";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/write_ok")
    public String writeOkPage(
            @SessionAttribute(value = "login") UserVO vo,
            HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            log.error("Error setting request encoding: ", e);
        }

        FileUpload fileUpload = new FileUpload();
        PerformanceVO performance = fileUpload.uploadFile(request, vo.getId());

        if (performance == null) {
            log.warn("File upload failed or invalid performance data.");
            return "redirect:/";
        }

        performanceService.addPerformance(performance);
        log.info("Performance successfully added: {}", performance);
        return "redirect:/performance/list";
    }

    @PostMapping("/delete/{id}")
    public String deletePerformance(
            @SessionAttribute(value = "login") UserVO vo,
            @PathVariable Integer id) {
        PerformanceVO performance = performanceService.getPerformanceById(id);
        if (performance == null) {
            log.warn("Performance not found with ID: {}", id);
            return "redirect:/performance/list";
        }

        Integer writerId = performance.getWriter_id();
        if (vo.checkAuth_admin() || (vo.checkAuth_manager() && Objects.equals(vo.getId(), writerId))) {
            performanceService.deletePerformanceById(id);
            log.info("Performance successfully deleted with ID: {}", id);
            return "redirect:/performance/list";
        } else {
            log.warn("Unauthorized attempt to delete performance with ID: {}", id);
            return "redirect:/performance/view/" + id;
        }
    }

    @GetMapping("/edit/{id}")
    public String editPage(
            @SessionAttribute(value = "login") UserVO vo,
            @PathVariable Integer id,
            Model model) {
        PerformanceVO performance = performanceService.getPerformanceById(id);
        if (performance == null) {
            log.warn("Performance not found with ID: {}", id);
            return "redirect:/performance/list";
        }

        Integer writerId = performance.getWriter_id();
        if (!vo.checkAuth_manager() || !Objects.equals(vo.getId(), writerId)) {
            log.warn("Unauthorized attempt to edit performance with ID: {}", id);
            return "redirect:/performance/view/" + id;
        }

        model.addAttribute("performance", performance);
        return "performance/edit";
    }

    @PostMapping("/edit_ok")
    public String editOkPage(
            @SessionAttribute(value = "login") UserVO vo,
            HttpServletRequest request,
            Model model) {
        if (!vo.checkAuth_admin() && !vo.checkAuth_manager()) {
            log.warn("Unauthorized access to edit performance.");
            return "redirect:/";
        }

        FileUpload fileUpload = new FileUpload();
        PerformanceVO updatedPerformance = fileUpload.uploadFile(request, vo.getId());
        if (updatedPerformance == null) {
            log.warn("File upload failed or invalid performance data.");
            model.addAttribute("error", "File upload failed or invalid input detected.");
            return "performance/edit";
        }

        PerformanceVO existingPerformance = performanceService.getPerformanceById(updatedPerformance.getId());
        if (existingPerformance == null) {
            log.warn("No existing performance found with ID: {}", updatedPerformance.getId());
            model.addAttribute("error", "Performance not found.");
            return "performance/edit";
        }

        // Update fields
        existingPerformance.setTitle(updatedPerformance.getTitle());
        existingPerformance.setCurrentNum(updatedPerformance.getCurrentNum());
        existingPerformance.setMaxNum(updatedPerformance.getMaxNum());
        existingPerformance.setPerformanceDate(updatedPerformance.getPerformanceDate());
        existingPerformance.setContent(updatedPerformance.getContent());
        if (updatedPerformance.getPosterFile() != null) {
            existingPerformance.setPosterFile(updatedPerformance.getPosterFile());
        }

        try {
            performanceService.updatePerformance(existingPerformance);
            log.info("Performance successfully updated: {}", existingPerformance);
            return "redirect:/performance/view/" + existingPerformance.getId();
        } catch (Exception e) {
            log.error("Error updating performance: ", e);
            model.addAttribute("error", "An error occurred while updating the performance. Please try again.");
            return "performance/edit";
        }
    }
}