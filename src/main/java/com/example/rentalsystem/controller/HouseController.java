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
        House house = serviceShowHouse.getHouseByID(houseid).get(0);
        model.addAttribute("house", house.toString());
        return "housedetail";
    }
    /**
     * 获取所有房源
     * @param pageNumber 页码，默认为1
     * @param numbersOfHousePerPage 每页展示的房源数量，默认为5
     * @return allhouse.html
     */
    @GetMapping("/allhouse")
    public String getAllHouse(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "5") int numbersOfHousePerPage, Model model){
        List<House> houses = serviceShowHouse.getAllHouse();
        List<House> reslist = new ArrayList<>();
        for(int i = (pageNumber-1)*numbersOfHousePerPage; i < pageNumber*numbersOfHousePerPage; i++)
            reslist.add(houses.get(i));
        model.addAttribute("allhouses", reslist);
        return "allhouse";
    }

    /**
     * 商务办公房源
     * @param pageNumber 当前页码，默认为1
     * @param numbersOfHousePerPage 每页展示房源的数量，默认为5
     * @return allhouse.html
     */
    @GetMapping("/commercialoffice")
    public String getCommercialOffice(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "5") int numbersOfHousePerPage, Model model){
        int kind = TypeConversion.changeHouseTypeToNumber("商业办公");
        List<House> houses = serviceShowHouse.getAllSpecificKindHouse(kind);
        List<House> reslist = new ArrayList<>();
        for(int i = (pageNumber-1)*numbersOfHousePerPage; i < pageNumber*numbersOfHousePerPage; i++)
            reslist.add(houses.get(i));
        model.addAttribute("allhouses", reslist);
        return "allhouse";
    }
}
