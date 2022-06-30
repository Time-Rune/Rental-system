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
     * @param model
     */
    private void addLatestHouse(Model model){
        List<House> houses = serviceShowHouse.getLastestHouse(4);
        /*
        最新房源展示
         */
        House test = new House();
        test.setHphoto("/XHS_1656418008466e5128622-da5a-3a04-aaae-66d82326.jpg");
        model.addAttribute("Houses0", test);

        for(int i = 0; i < houses.size(); i++){
            model.addAttribute("Latesthouses" + i, houses.get(i));
        }
    }
    private void addCommercialOffice(Model model){
        int houseId = TypeConversion.changeHouseTypeToNumber("商业办公");
        List<House> houses = serviceShowHouse.getSpecificKindHouse(houseId);
        for(int i = 0; i < houses.size(); i++){
            model.addAttribute("CommercialOffice" + i, houses.get(i));
        }
    }
    private void addOrdinaryResidence(Model model){
        int houseId = TypeConversion.changeHouseTypeToNumber("普通民宅");
        List<House> houses = serviceShowHouse.getSpecificKindHouse(houseId);
        for(int i = 0; i < houses.size(); i++){
            model.addAttribute("CommercialOffice" + i, houses.get(i));
        }
    }
    private void addHotelHouse(Model model){
        int houseId = TypeConversion.changeHouseTypeToNumber("酒店住宅");
        List<House> houses = serviceShowHouse.getSpecificKindHouse(houseId);
        for(int i = 0; i < houses.size(); i++){
            model.addAttribute("CommercialOffice" + i, houses.get(i));
        }
    }
    private void addLatestNews(Model model){
        List<News> newslist = serviceNews.getLatestNews(10);
        for(int i = 0; i < newslist.size(); i++)
            model.addAttribute("LatestNews" + i, newslist.get(i));
    }
}
