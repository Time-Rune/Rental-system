package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.Admins;
import com.example.rentalsystem.service.ServiceAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/admin", method = RequestMethod.GET, produces = "application/json")
public class AdminReceive {

    @Autowired
    private ServiceAdmin serviceAdmin;

    @GetMapping(value = "/select")
    public ModelAndView searchAdmin(HttpServletRequest http){
        ModelAndView view = new ModelAndView("newManage::AdminTable");
        view.addObject("admin_list", serviceAdmin.searchAdmin(http.getParameter("search")));
        return view;
    }

//    @PostMapping(value = "/select")
//    public ModelAndView searchUser(HttpServletRequest http){
//        ModelAndView view = new ModelAndView("newManage::user-userTable");
//        view.addObject("user_list", serviceUser.searchUser(http.getParameter("search")));
//        return view;
//    }

    @PostMapping(value = "/insert")
    public ModelAndView insertAdmin(HttpServletRequest http){
        serviceAdmin.insertAdmin(http.getParameter("account"), http.getParameter("name"),
                http.getParameter("password"), http.getParameter("phone"));
        ModelAndView view = new ModelAndView("newManage::AdminTable");
        view.addObject("admin_list", serviceAdmin.selectAllAdmin());
        return view;
    }

    @PostMapping(value = "/update")
    public ModelAndView updateAdmin(HttpServletRequest http){
        serviceAdmin.updateAdmin(Integer.parseInt(http.getParameter("id")), http.getParameter("account"),
                http.getParameter("password"), http.getParameter("name"), http.getParameter("phone"));
        ModelAndView view = new ModelAndView("newManage::AdminTable");
        view.addObject("admin_list", serviceAdmin.selectAllAdmin());
        return view;
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteAdmin(HttpServletRequest http){
        serviceAdmin.deleteAdmin(Integer.parseInt(http.getParameter("id")));
        ModelAndView view = new ModelAndView("newManage::AdminTable");
        view.addObject("admin_list", serviceAdmin.selectAllAdmin());
        return view;
    }

}
