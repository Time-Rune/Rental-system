package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.service.ServiceShowLatestHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private ServiceShowLatestHouse serviceShowLatestHouse;
    /**
     * 主页
     */
    @RequestMapping("/index")
    public String pageIndex(Model model){
        List<House> houses = serviceShowLatestHouse.getLastestHouse(4);
        HashMap<String, House> latestHouses = new HashMap<String, House>();
        for(int i = 0; i < houses.size(); i++){
            latestHouses.put("LatestHouse" + Integer.toString(i), houses.get(i));
        }
        model.addAllAttributes(latestHouses);
        return "index";
    }
}
