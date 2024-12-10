package com.team.user.controller;

import com.team.user.VO.UserVO;
import com.team.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    public UserService userService;


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testMethod(Model model){
        UserVO user = userService.getUserById(1);
        model.addAttribute("user_id", user.getUser_id());
        return "test";
    }
}
