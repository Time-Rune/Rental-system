package com.example.rentalsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usercenter")
public class UserCenterController {
    @GetMapping("/")
    public String userCenter(){
        return "/user";
    }
}
