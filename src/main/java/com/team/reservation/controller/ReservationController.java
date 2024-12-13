package com.team.reservation.controller;

import com.team.reservation.VO.ReservationVO;
import com.team.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    /**
     * Display reservation form
     */
    @RequestMapping(value = "/reservation/write", method = RequestMethod.GET)
    public String writeReservationPage(HttpSession session) {
        // Check if user is logged in
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        return "user/reservation/write";
    }

    /**
     * Process reservation form submission
     */
    @RequestMapping(value = "/reservation/write_ok", method = RequestMethod.POST)
    public String writeReservationOkPage(@ModelAttribute ReservationVO reservation, HttpSession session) {
        // Get userId from session
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        // Set userId in reservation object
        reservation.setUserId(userId);

        // Save reservation
        reservationService.addReservation(reservation);
        return "redirect:/user/reservations";
    }

    /**
     * Display user reservations
     */
    @RequestMapping(value = "/user/reservations", method = RequestMethod.GET)
    public String reservationListPage(Model model, HttpSession session) {
        // Check if user is logged in
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        // Fetch reservations for user
        model.addAttribute("reservations", reservationService.getUserReservations(userId));
        return "user/reservation/view";
    }
}