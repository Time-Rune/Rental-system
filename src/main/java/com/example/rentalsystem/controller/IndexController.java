package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.entity.News;
import com.example.rentalsystem.repository.ShowHouseSQL;
import com.example.rentalsystem.service.ServiceNews;
import com.example.rentalsystem.service.ServiceShowHouse;
import com.example.rentalsystem.utils.TypeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ServiceShowHouse serviceShowHouse;
    @Autowired
    private ServiceNews serviceNews;
    /**
     * 主页
     */
    @GetMapping("/index")
    public String pageIndex(Model model){
        addLatestHouse(model);
        addCommercialOffice(model);
        addHotelHouse(model);
        addOrdinaryResidence(model);
        return "index";
    }

    /**
     * 传输最新房源数据
     */
    private void addLatestHouse(Model model){
        int numbers = 4;
        List<House> houses = serviceShowHouse.getLastestHouse(numbers);
        model.addAttribute("LatestHouseList", houses);
    }
    private void addCommercialOffice(Model model){
        int numbers = 4;
        int houseId = TypeConversion.changeHouseTypeToNumber("商业办公");
        List<House> houses = serviceShowHouse.getSpecificKindHouse(houseId, numbers);
        for(int i = 0; i < houses.size(); i++)
            System.out.println(houses.get(i));
        model.addAttribute("CommercialOfficeList", houses);
    }
    private void addOrdinaryResidence(Model model){
        int numbers = 4;
        int houseId = TypeConversion.changeHouseTypeToNumber("普通民宅");
        List<House> houses = serviceShowHouse.getSpecificKindHouse(houseId, numbers);
        model.addAttribute("OrdinaryHouseList", houses);
    }
    private void addHotelHouse(Model model){
        int numbers = 4;
        int houseId = TypeConversion.changeHouseTypeToNumber("酒店住宅");
        List<House> houses = serviceShowHouse.getSpecificKindHouse(houseId, numbers);
        model.addAttribute("HotelHouseList", houses);
    }
    private void addLatestNews(@RequestParam(defaultValue = "5") int numbersOfNews, Model model){
        List<News> newslist = serviceNews.getLatestNews(numbersOfNews);
        model.addAttribute("LatestNews", newslist);
    }
}
