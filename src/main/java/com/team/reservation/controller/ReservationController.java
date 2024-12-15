package com.team.reservation.controller;

import com.team.reservation.service.ReservationService;
import com.team.reservation.VO.ReservationVO;
import com.team.user.VO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "/mypage", method = RequestMethod.GET)
    public String reservationListPage(@SessionAttribute(value = "login") UserVO vo, Model model) {

        List<ReservationVO> reservations = reservationService.getUserReservations(vo.getId());
        model.addAttribute("reservations", reservations);

        return "user/reservation/list";
    }

    @RequestMapping(value = "/reservations/add", method = RequestMethod.GET)
    public String reservationListPage(@SessionAttribute(value = "login") UserVO vo, Model model, @PathVariable Integer id) {

        List<ReservationVO> reservations = reservationService.getUserReservations(vo.getId());
        model.addAttribute("reservations", reservations);
//        id;


        return "user/reservation/list";
    }
}