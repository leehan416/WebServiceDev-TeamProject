package com.team.reservation.controller;

import com.team.reservation.service.ReservationService;
import com.team.reservation.VO.ReservationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/user/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    /**
     * Display the list of reservations for the logged-in user.
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String reservationListPage(Model model, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "user/login/login"; // Redirect to login if user is not logged in
        }

        List<ReservationVO> reservations = reservationService.getUserReservations(userId);
        model.addAttribute("reservations", reservations);

        return "user/reservation/list"; // Path to list.jsp
    }
}