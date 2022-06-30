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

import static java.lang.Math.min;

@Slf4j
@Controller
public class TestController {
    @Autowired
    private ServiceShowHouse serviceShowHouse;

    @GetMapping("/login")
    public String login(int kind, Model model){
        List<House> houses = serviceShowHouse.getSpecificKindHouse(kind);

        for (int i = 0;i < 2;++ i){
            model.addAttribute("house" + i, houses.get(i).toString());
        }

        return "success";
    }
}
//        System.out.format("main_count = %d\n", timecounter.getCounter());
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//        Date date = new Date(System.currentTimeMillis());
//        System.out.println(formatter.format(date));
//        model.addAttribute("mess", formatter.format(date));