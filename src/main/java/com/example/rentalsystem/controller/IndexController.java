package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.service.ServiceShowLatestHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/index")
    public String pageIndex(Model model){
        List<House> houses = serviceShowLatestHouse.getLastestHouse(4);
        /*
        最新房源展示
         */
        House test = new House();
        test.setHphoto("/XHS_1656418008466e5128622-da5a-3a04-aaae-66d82326.jpg");
        model.addAttribute("Houses0", test);

        for(int i = 0; i < houses.size(); i++){
            model.addAttribute("Latesthouses" + i, houses.get(i));
        }
        return "index";
    }
}
