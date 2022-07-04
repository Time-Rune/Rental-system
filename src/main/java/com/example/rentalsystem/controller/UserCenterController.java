package com.example.rentalsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserCenterController {
    @GetMapping("/usercenter")
    public String userCenter(){
        return "/user";
    }
}
