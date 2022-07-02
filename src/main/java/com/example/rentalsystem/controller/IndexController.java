package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.entity.News;
import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.repository.ShowHouseSQL;
import com.example.rentalsystem.service.ServiceNews;
import com.example.rentalsystem.service.ServiceShowHouse;
import com.example.rentalsystem.utils.TypeConversion;
import com.example.rentalsystem.utils.UserContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
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
        addLatestNews(model);
        return "index";
    }

    @RequestMapping("/getuserinfo")
    public void getUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute(UserContext.getUserInfoID());

        if(user != null){
            System.out.println("GetUser!!!");
            System.out.println("response:" + response.getOutputStream());
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(response.getOutputStream(), user);
            String resjson = objectMapper.writeValueAsString(user);
        }
        else{
            System.out.println("NullUser!!");
        }
    }

    /**
     * 房源展示相关
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
        int houseId = TypeConversion.changeHouseTypeToNumber("酒店式公寓");
        List<House> houses = serviceShowHouse.getSpecificKindHouse(houseId, numbers);
        for (House house : houses) System.out.println(house.getHID());
        model.addAttribute("HotelHouseList", houses);
    }

    /**
     * 展示首页新闻推荐
     */
    private void addLatestNews(Model model){
        int numbersOfNews = 5;
        List<News> newslist = serviceNews.getLatestNews(numbersOfNews);
        model.addAttribute("LatestNewsList", newslist);
    }

    /**
     * 展示热门房源
     */
    private void addHotHouse(Model model){
        //sum: 热门房源展示数量
        int sum = 5;
        List<House> houses = serviceShowHouse.getHotHouse(sum);
        model.addAttribute("HotHousesList", houses);
    }
}
