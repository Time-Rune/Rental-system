package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.News;
import com.example.rentalsystem.service.ServiceNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
public class NewsDetailController {
    @Autowired
    private ServiceNews serviceNews;

    @GetMapping("/shownews")
    public String showNewsDetails(int id, Model model){
        News news = serviceNews.getNewsByID(id);
        model.addAttribute("news", news);
        return "new";
    }
}
