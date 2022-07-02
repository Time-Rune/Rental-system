package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.service.ServiceShowHouse;
import com.example.rentalsystem.service.ServiceUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
//@RequestMapping(value = "/user")

@RequestMapping("demo")
public class TestController {
    @Autowired
    private ServiceUser serviceUser;

//    @GetMapping("/login")
    public ModelAndView login(Model model) {
//        List<House> houses = serviceShowHouse.getLastestHouse(num);
//        model.addAttribute("houses", houses);
        ModelAndView view = new ModelAndView("Manage");
        view.addObject("user_list", serviceUser.selectAllUser());
        return view;
    }

}
