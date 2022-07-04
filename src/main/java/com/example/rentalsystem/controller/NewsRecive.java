package com.example.rentalsystem.controller;

import com.example.rentalsystem.service.ServiceNews;
import org.apache.taglibs.standard.lang.jstl.NamedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/news", method = RequestMethod.GET, produces = "application/json")
public class NewsRecive {
    @Autowired
    ServiceNews serviceNews;

    @GetMapping(value = "/select")
    public ModelAndView searchNews(HttpServletRequest http){
        ModelAndView view = new ModelAndView("newManage::NewsTable");
        view.addObject("news_list", serviceNews.searchNews(http.getParameter("search")));
        return view;
    }

    @PostMapping(value = "/update")
    public ModelAndView updateNews(HttpServletRequest http){
        serviceNews.updateNews(Integer.parseInt(http.getParameter("id")),
                Integer.parseInt(http.getParameter("post")), http.getParameter("header"),
                http.getParameter("date"), Integer.parseInt(http.getParameter("click")));
        ModelAndView view = new ModelAndView("newManage::NewsTable");
        view.addObject("news_list", serviceNews.getAllNews());
        return view;
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteNews(HttpServletRequest http){
        serviceNews.deleteNews(Integer.parseInt(http.getParameter("id")));
        ModelAndView view = new ModelAndView("newManage::NewsTable");
        view.addObject("news_list", serviceNews.getAllNews());
        return view;
    }

}
