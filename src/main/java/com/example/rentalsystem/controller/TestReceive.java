package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
public class TestReceive {

    @Autowired
    private ServiceUser serviceUser;


    @PostMapping(value = "/insert")
    public ModelAndView insertUser(HttpServletRequest httpServletRequest){
//        serviceUser.insertUser(httpServletRequest.getParameter("username"), httpServletRequest.getParameter("nickname"), httpServletRequest.getParameter("password"));
        ModelAndView view = new ModelAndView("Manage::userTable");
        view.addObject("user_list", serviceUser.selectAllUser());
        return view;
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteUser(HttpServletRequest httpServletRequest){
        serviceUser.deleteUser(Integer.parseInt(httpServletRequest.getParameter("id")));
        ModelAndView view = new ModelAndView("Manage::userTable");
        view.addObject("user_list", serviceUser.selectAllUser());
        return view;
    }
}
