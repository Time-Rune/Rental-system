package com.example.rentalsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Slf4j
@Controller
//@RequestMapping("/")
public class LoginController {
//    @ResponseBody
//    @Value("${message}")
    private int count;
    @GetMapping("/login")
    public String login(String account, String password, Model model){
        for(int i = 0; i < 300; i++){
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println("cout = ", count);
            count += 1;
            model.addAttribute("mess", "count");
        }
        return "success";
    }
}
