package com.example.rentalsystem.controller;

import com.example.rentalsystem.service.ServiceShowHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/house", method = RequestMethod.GET, produces = "application/json")
public class HouseReceive {
    @Autowired
    private ServiceShowHouse serviceShowHouse;

    @PostMapping(value = "/insert")
    public ModelAndView insertHouse(HttpServletRequest http){
        serviceShowHouse.insertHouse(http.getParameter("name"), Integer.parseInt(http.getParameter("kind")),
                Integer.parseInt(http.getParameter("cost")), Integer.parseInt(http.getParameter("area")),
                Integer.parseInt(http.getParameter("floor")), Integer.parseInt(http.getParameter("direct")),
                Integer.parseInt(http.getParameter("owner")));
        ModelAndView view = new ModelAndView("newManage::HouseTable");
        view.addObject("house_list", serviceShowHouse.getAllHouse());
        return view;
    }

    @PostMapping(value = "/update")
    public ModelAndView updateHouse(HttpServletRequest http){
        serviceShowHouse.updateHouse(Integer.parseInt(http.getParameter("id")),
                http.getParameter("name"), Integer.parseInt(http.getParameter("kind")),
                Integer.parseInt(http.getParameter("cost")), Integer.parseInt(http.getParameter("area")),
                Integer.parseInt(http.getParameter("floor")), Integer.parseInt(http.getParameter("direct")),
                Integer.parseInt(http.getParameter("owner")), Integer.parseInt(http.getParameter("click")));
        ModelAndView view = new ModelAndView("newManage::HouseTable");
        view.addObject("house_list", serviceShowHouse.getAllHouse());
        return view;
    }

    @PostMapping(value = "/delete")
    private ModelAndView deleteHouse(HttpServletRequest http){
        serviceShowHouse.deleteHouse(Integer.parseInt(http.getParameter("id")));
        ModelAndView view = new ModelAndView("newManage::HouseTable");
        view.addObject("house_list", serviceShowHouse.getAllHouse());
        return view;
    }

    @GetMapping(value = "/search")
    private ModelAndView searchHouse(HttpServletRequest http){
        ModelAndView view = new ModelAndView("newManage::HouseTable");
        view.addObject("house_list", serviceShowHouse.searchHouse(http.getParameter("search")));
        return view;
    }

}
