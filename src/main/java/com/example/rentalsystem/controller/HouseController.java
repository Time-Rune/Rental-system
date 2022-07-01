package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.service.ServiceShowHouse;
import com.example.rentalsystem.utils.TypeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private ServiceShowHouse serviceShowHouse;

    /**
     * 房源详情页
     * @param houseid 房屋id
     * @return housedetail.html
     */
    @GetMapping("/housedetail")
    public String getHouseDetial(int houseid, Model model){
        serviceShowHouse.increaseHouseHclick(houseid);
        House house = serviceShowHouse.getHouseByID(houseid).get(0);
        model.addAttribute("house", house);
        addHotHouse(model);
        return "housedetail";
    }
    /**
     * 获取所有房源
     * @param pageNumber 页码，默认为1
     * @param numbersOfHousePerPage 每页展示的房源数量，默认为5
     * @param model allHousesList 全部房源列表 HotHousesList 热门房源列表
     * @return allhouse.html
     */
    @GetMapping("/allhouse")
    public String getAllHouse(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "6") int numbersOfHousePerPage, Model model){
        List<House> houses = serviceShowHouse.getAllHouse();
        List<House> reslist = new ArrayList<>();
        for(int i = (pageNumber-1)*numbersOfHousePerPage; i < pageNumber*numbersOfHousePerPage; i++)
            reslist.add(houses.get(i));
        model.addAttribute("allHousesList", reslist);
        addHotHouse(model);
        return "allhouse";
    }

    /**
     * @param model  allCommercialOfficeList 商务办公列表 hotHousesList 热门房源列表
     * @param pageNumber 当前页码，默认为1
     * @param numbersOfHousePerPage 每页展示房源的数量，默认为5
     * @return commercialoffice.html
     */
    @GetMapping("/commercialoffice")
    public String getCommercialOffice(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "5") int numbersOfHousePerPage, Model model){
        int kind = TypeConversion.changeHouseTypeToNumber("商业办公");
        List<House> houses = serviceShowHouse.getAllSpecificKindHouse(kind);
        List<House> reslist = new ArrayList<>();
        for(int i = (pageNumber-1)*numbersOfHousePerPage; i < pageNumber*numbersOfHousePerPage; i++)
            reslist.add(houses.get(i));
        model.addAttribute("allCommercialOfficeList", reslist);
        addHotHouse(model);
        return "/commercialoffice";
    }
    /**
     * @param model allCommonHouseList 普通民宅列表 hotHousesList 热门房源列表
     * @param pageNumber 当前页码，默认为1
     * @param numbersOfHousePerPage 每页展示房源的数量，默认为5
     * @return commonhouse.html
     */
    @GetMapping("/commonhouse")
    public String getcommonhouse(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "5") int numbersOfHousePerPage, Model model){
        int kind = TypeConversion.changeHouseTypeToNumber("普通民宅");
        List<House> houses = serviceShowHouse.getAllSpecificKindHouse(kind);
        List<House> reslist = new ArrayList<>();
        for(int i = (pageNumber-1)*numbersOfHousePerPage; i < pageNumber*numbersOfHousePerPage; i++)
            reslist.add(houses.get(i));
        model.addAttribute("allCommonHouseList", reslist);
        addHotHouse(model);
        return "/commonhouse";
    }

    /**
     * @param pageNumber 当前页码，默认为1
     * @param numbersOfHousePerPage 每页数量，默认为5
     * @param model allHotelHouseList 酒店式公寓列表 hotHousesList 热门房源列表
     * @return hotelhouse.html
     */
    @GetMapping("/hotelhouse")
    public String getHotelHouse(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "5") int numbersOfHousePerPage, Model model){
        int kind = TypeConversion.changeHouseTypeToNumber("酒店式公寓");
        List<House> houses = serviceShowHouse.getAllSpecificKindHouse(kind);
        List<House> reslist = new ArrayList<>();
        for(int i = (pageNumber-1)*numbersOfHousePerPage; i < pageNumber*numbersOfHousePerPage; i++)
            reslist.add(houses.get(i));
        model.addAttribute("allHotelHouseList", reslist);
        addHotHouse(model);
        return "/hotelhouse";
    }

    /**
     * 搜索结果
     * @param keyword 搜索关键字
     * @param model SearchResultList 搜索结果列表 HotHousesList 热门房源列表
     * @return searchhouse.html
     */
    @GetMapping("/searchhouse")
    public String searchHouseByName(@RequestParam(defaultValue = "") String keyword, Model model){
        List<House> houses = serviceShowHouse.searchHouseByName(keyword);
        model.addAttribute("SearchResultList", houses);
        addHotHouse(model);
        return "searchhouse";
    }

    private void addHotHouse(Model model){
        //sum: 热门房源展示数量
        int sum = 4;
        List<House> houses = serviceShowHouse.getHotHouse(sum);
        model.addAttribute("HotHousesList", houses);
    }

}
