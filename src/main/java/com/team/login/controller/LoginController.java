package com.team.login.controller;

import com.team.user.VO.UserVO;
import com.team.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login")
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loginPage(HttpSession session) {
        if (session.getAttribute("login") != null) {
            return "redirect:/";
        }
        return "user/login/login";
    }

    @RequestMapping(value = "/loginOk", method = RequestMethod.POST)
    public String loginCheck(HttpSession session, UserVO vo) {
        log.info("==========================================");
        log.info("id = {} password = {}", vo.getUser_id(), vo.getPassword());

        if (session.getAttribute("login") != null) {
            session.removeAttribute("login");
        }

        UserVO loginvo = userService.getUser(vo);

        if (loginvo != null) {
            log.info("login success!");
            session.setAttribute("login", loginvo);
            session.setAttribute("userId", log);

            return "redirect:/";
        } else {
            log.info("login fail!");
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}