package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.entity.News;
import com.example.rentalsystem.service.ServiceNews;
import com.example.rentalsystem.service.ServiceShowHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HouseDetail {
    @Autowired
    private ServiceShowHouse serviceShowHouse;

    @GetMapping("/housedetail")
    public String getHouseDetial(int houseid, Model model){
        House house = serviceShowHouse.getHouseByID(houseid).get(0);
        model.addAttribute("house");
        return "housedetail";
    }
}
