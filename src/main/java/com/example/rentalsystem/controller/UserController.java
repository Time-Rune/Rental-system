package com.example.rentalsystem.controller;

import com.example.rentalsystem.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController

@RequestMapping("demo")
public class UserController {
    @Autowired
    private ServiceUser serviceUser;

    @GetMapping("/login")
    public ModelAndView login(Model model) {
//        List<House> houses = serviceShowHouse.getLastestHouse(num);
//        model.addAttribute("houses", houses);
        ModelAndView view = new ModelAndView("NewManage");
        view.addObject("user_list", serviceUser.selectAllUser());
        return view;
    }

}
