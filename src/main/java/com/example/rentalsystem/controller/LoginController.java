package com.example.rentalsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
//@RequestMapping("/")
public class LoginController {
//    @ResponseBody
//    @Value("${message}")
    @Autowired
    private Timecounter timecounter;
    @GetMapping("/login")
    public String login(String account, String password, Model model){
        System.out.format("main_count = %d\n", timecounter.getCounter());
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        model.addAttribute("mess", formatter.format(date));

        return "success";
    }
}
