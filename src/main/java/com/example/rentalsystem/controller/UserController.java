package com.example.rentalsystem.controller;

import com.example.rentalsystem.service.ServiceAdmin;
import com.example.rentalsystem.service.ServiceContract;
import com.example.rentalsystem.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController

@RequestMapping("")
public class UserController {
    @Autowired
    private ServiceUser serviceUser;

    @Autowired
    private ServiceAdmin serviceAdmin;

    @Autowired
    private ServiceContract serviceContract;

    @GetMapping("/admincenter")
    public ModelAndView login(Model model) {
//        List<House> houses = serviceShowHouse.getLastestHouse(num);
//        model.addAttribute("houses", houses);
        ModelAndView view = new ModelAndView("newManage");
        view.addObject("user_list", serviceUser.selectAllUser());
        view.addObject("admin_list", serviceAdmin.selectAllAdmin());
        view.addObject("con_list", serviceContract.selectAllContract());
        return view;
    }

}
