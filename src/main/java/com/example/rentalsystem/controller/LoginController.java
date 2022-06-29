package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.service.ServiceShowLatestHouse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
//@RequestMapping("/")
public class LoginController {
    @Autowired
    private ServiceShowLatestHouse serviceShowLatestHouse;
    private int count;

    @GetMapping("/test")
    public String login(String account, String password, Model model){
        List<House> houses = serviceShowLatestHouse.getLastestHouse(4);
        House test = new House();
        test.setHphoto("/XHS_1656418008466e5128622-da5a-3a04-aaae-66d82326.jpg");
        model.addAttribute("Houses0", test);

        for(int i = 0; i < houses.size(); i++){
            model.addAttribute("Latesthouses" + i, houses.get(i));
        }
        return "success";
    }
//    登录注册
    @PostMapping("/login")
    public String main(String username,String password){
        return "index";
    }
}
