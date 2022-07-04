package com.example.rentalsystem.controller;

import com.example.rentalsystem.service.ServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/contract", method = RequestMethod.GET, produces = "application/json")
public class ContractReceive {
    @Autowired
    private ServiceContract serviceContract;

    @PostMapping(value = "/insert")
    public ModelAndView insertContract(HttpServletRequest http){
        serviceContract.addContract(Integer.parseInt(http.getParameter("uid1")),
                Integer.parseInt(http.getParameter("uid2")),
                Integer.parseInt(http.getParameter("hid")),
                http.getParameter("begin"), http.getParameter("end"));
        ModelAndView view = new ModelAndView("newManage::ContractTable");
        view.addObject("con_list", serviceContract.selectAllContract());
        return view;
    }

    @PostMapping(value = "update")
    public ModelAndView updateContract(HttpServletRequest http){
        serviceContract.updateContract(Integer.parseInt(http.getParameter("id")),
                Integer.parseInt(http.getParameter("uid1")),
                Integer.parseInt(http.getParameter("uid2")),
                http.getParameter("begin"),
                http.getParameter("end"),
                Integer.parseInt(http.getParameter("hid")));
        ModelAndView view = new ModelAndView("newManage::ContractTable");
        view.addObject("con_list", serviceContract.selectAllContract());
        return view;
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteContract(HttpServletRequest http){
        serviceContract.deleteContract(Integer.parseInt(http.getParameter("id")));
        ModelAndView view = new ModelAndView("newManage::ContractTable");
        view.addObject("con_list", serviceContract.selectAllContract());
        return view;
    }

    @GetMapping(value = "/select")
    public ModelAndView searchContract(HttpServletRequest http){
        ModelAndView view = new ModelAndView("newManage::ContractTable");
        view.addObject("con_list", serviceContract.searcthConstract(http.getParameter("search")));
        return view;
    }


}
