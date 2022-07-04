package com.example.rentalsystem.controller;

import com.example.rentalsystem.service.ServiceWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/word", method = RequestMethod.GET, produces = "application/json")
public class WordReceive {
    @Autowired
    private ServiceWord serviceWord;

    @PostMapping(value = "/delete")
    public ModelAndView deleteWord(HttpServletRequest http){
        serviceWord.deleteWord(Integer.parseInt(http.getParameter("id")));
        ModelAndView view = new ModelAndView("newManage::WordTable");
        view.addObject("word_list", serviceWord.getAllWords());
        return view;
    }

    @PostMapping(value = "/update")
    public ModelAndView updateWord(HttpServletRequest http){
        serviceWord.updateWord(Integer.parseInt(http.getParameter("id")),
                Integer.parseInt(http.getParameter("post")),
                Integer.parseInt(http.getParameter("click")), http.getParameter("date"));
        ModelAndView view = new ModelAndView("newManage::WordTable");
        view.addObject("word_list", serviceWord.getAllWords());
        return view;
    }

    @PostMapping(value = "/select")
    public ModelAndView searchWord(HttpServletRequest http){
        ModelAndView view = new ModelAndView("newManage::WordTable");
        view.addObject("word_list", serviceWord.searchWord(http.getParameter("search")));
        return view;
    }
}
