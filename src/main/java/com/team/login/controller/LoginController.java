package com.team.login.controller;

import com.team.user.VO.UserVO;
import com.team.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login")
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginPage() {
        return "user/login/login";
    }

    @RequestMapping(value = "/loginOk", method = RequestMethod.POST)
    public String loginCheck(HttpSession session, UserVO vo) {

        // log start
        log.info("==========================================");

        // log for information
        log.info("id = {} passwod = {}", vo.getUser_id(), vo.getPassword());

        // return value (redirection)
        String returnURL;

        // if there are already login session
        if (session.getAttribute("login") != null)
            session.removeAttribute("login"); // remove login session

        // get user vo by id
        UserVO loginvo = userService.getUser(vo);

        // login success
        if (loginvo != null) { // 로그인 성공

            // log for success
            log.info("login success!");

            // session set
            session.setAttribute("login", loginvo);

            // redirection set
            returnURL = "redirect:/performance/list";
        }
        // login fail
        else {
            // log for fail
            log.info("login fail!");

            // redirection set
            returnURL = "redirect:/login";
        }

        // log end
        log.info("==========================================");

        // redirection
        return returnURL;
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        // session remove
        session.invalidate();
        return "redirect:/login";
    }
}