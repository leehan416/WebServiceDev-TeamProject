package com.team.reservation.controller;

import com.team.performance.VO.PerformanceVO;
import com.team.reservation.service.ReservationService;
import com.team.reservation.VO.ReservationVO;
import com.team.user.VO.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping(value = "reservations")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @RequestMapping(value = "/mypage", method = RequestMethod.GET)
    public String reservationListPage(@SessionAttribute(value = "login") UserVO vo, Model model) {

        List<ReservationVO> reservations = service.getUserReservations(vo.getId());
        model.addAttribute("reservations", reservations);
        return "user/reservation/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addReservation(@SessionAttribute(value = "login") UserVO vo, @RequestParam Integer id) {

        // success
        if (service.addReservation(vo.getId(), id) != 0)
            return "redirect:/reservations/mypage";

        //fail
        return "redirect:/performance/view/" + id;
    }
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeReservation(@SessionAttribute(value = "login") UserVO vo,  @RequestParam Integer id) {

        // success
        if (service.removeReservation(vo.getId(), id)!= 0)
            return "redirect:/reservations/mypage";

        //fail
        return "redirect:/performance/view/" + id;
    }
}