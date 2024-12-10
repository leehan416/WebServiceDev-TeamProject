package com.team.login.controller;

import com.team.user.VO.UserVO;
import com.team.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }


    @RequestMapping(value = "/loginOk", method = RequestMethod.POST)
    public String loginCheck(HttpSession session, UserVO vo) {
        String returnURL = "list";
        if (session.getAttribute("login") != null) {
            session.removeAttribute("login");
        }
        UserVO loginvo = userService.getUser(vo);
        if (loginvo != null) { // 로그인 성공
            System.out.println("로그인 성공!");
            session.setAttribute("login", loginvo);
            returnURL = "redirect:/board/list";
        } else { // 로그인 실패
            System.out.println("로그인 실패!");
            returnURL = "redirect:/login";
        }
        return returnURL;
///login/loginOk
    }

    // 로그아웃 하는 부분
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}