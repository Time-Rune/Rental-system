package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.service.ServiceShowHouse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/")
public class LoginController {

    

}


//@GetMapping("/login2")
//    public String login(String account, String password, Model model){
//        List<House> houses = serviceShowHouse.getLastestHouse(4);
//        House test = new House();
//        test.setHphoto("/XHS_1656418008466e5128622-da5a-3a04-aaae-66d82326.jpg");
//        model.addAttribute("Houses0", test);
//
//        for(int i = 0; i < houses.size(); i++){
//            model.addAttribute("Latesthouses" + i, houses.get(i));
//        }
//        return "index";
//    }