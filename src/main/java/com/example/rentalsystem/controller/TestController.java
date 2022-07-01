package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.service.ServiceShowHouse;
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
import java.util.List;


@Slf4j
@Controller
public class TestController {
    @Autowired
    private ServiceShowHouse serviceShowHouse;

    @GetMapping("/login")
    public String login(int num, Model model) {
        List<House> houses = serviceShowHouse.getLastestHouse(num);
        model.addAttribute("houses", houses);
        return "success";
    }

}
