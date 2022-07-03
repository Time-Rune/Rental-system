package com.example.rentalsystem.controller;

import com.example.rentalsystem.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
public class UserReceive {

    @Autowired
    private ServiceUser serviceUser;

    @PostMapping(value = "/insert")
    public ModelAndView insertUser(HttpServletRequest http) {
//        serviceUser.insertUser(http.getParameter("account"), http.getParameter("password"),
//                http.getParameter("name"), http.getParameter("sex"),
//                http.getParameter("birth"), http.getParameter("phone"));
        serviceUser.insertUser(http.getParameter("account"), http.getParameter("password"),
                http.getParameter("name"), "男",
                "2020-02-14", "12312321");
        ModelAndView view = new ModelAndView("Manage::user-userTable");
        view.addObject("user_list", serviceUser.selectAllUser());
        return view;
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteUser(HttpServletRequest httpServletRequest){
        serviceUser.deleteUser(Integer.parseInt(httpServletRequest.getParameter("id")));
        ModelAndView view = new ModelAndView("Manage::user-userTable");
        view.addObject("user_list", serviceUser.selectAllUser());
        return view;
    }

    @PostMapping(value = "/update")
    public ModelAndView updataUser(HttpServletRequest http){
        serviceUser.updateUser(Integer.parseInt(http.getParameter("id")), http.getParameter("account"),
                http.getParameter("password"), http.getParameter("name"), http.getParameter("sex"),
                http.getParameter("birth"), http.getParameter("phone"));
        ModelAndView view = new ModelAndView("Manage::userTable");
        view.addObject("user_list", serviceUser.selectAllUser());
        return view;
    }

    @PostMapping(value = "/select")
    public ModelAndView searchUser(HttpServletRequest http){
        ModelAndView view = new ModelAndView("Manage::userTable");
        view.addObject("user_list", serviceUser.searchUser(http.getParameter("search")));
        return view;
    }
}
