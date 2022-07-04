package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.entity.News;
import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.entity.Word;
import com.example.rentalsystem.service.ServiceNews;
import com.example.rentalsystem.service.ServiceShowHouse;
import com.example.rentalsystem.service.ServiceWord;
import com.example.rentalsystem.utils.ShowWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("/contact")
public class LeavingMessageController {
    @Autowired
    ServiceWord serviceWord;
    @Autowired
    ServiceShowHouse serviceShowHouse;
    @Autowired
    ServiceNews serviceNews;

    @GetMapping("/showcontact")
    public String ShowContact(Model model){
        addHotHouse(model);
        addLatestNews(model);
        return "richtext";
    }

    @RequestMapping(value = "/processdata", method = RequestMethod.POST, produces = "application/json")
    public ModelAndView processData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String htmltext = request.getParameter("Text");
        System.out.println("HtmlText: " + htmltext);
        Enumeration<String> paramName = request.getParameterNames();
        String param = paramName.nextElement();
        System.out.println("param: " + param);
        User user = serviceWord.getPosterByID();
        System.out.println("当前留言用户：" + user.getUname());
        String photo = user.getUphoto();
        String name = user.getUname();
        serviceWord.insertWord(param);

//        String richtext = "<h1>一级标题</h1><h2>二级标题</h2><p>正文</p>";
//        model.addAttribute("testword", richtext);

        ModelAndView modelAndView = new ModelAndView("/temp/submit_text::userTable");
        List<ShowWord> showWordList = new ArrayList<>();
        List<Word> wordList = serviceWord.getPerPageWords(1, 10);
        for(Word word: wordList){
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String postTime  = simpleDateFormat.format(date);
            ShowWord showWord = new ShowWord(name, photo, word.getWtext(), postTime);
            showWordList.add(showWord);
            System.out.println(showWord.toString());
        }
        modelAndView.addObject("wordList", showWordList);
        return modelAndView;
    }

    private void addHotHouse(Model model){
        //sum: 热门房源展示数量
        int sum = 5;
        List<House> houses = serviceShowHouse.getHotHouse(sum);
        model.addAttribute("HotHousesList", houses);
    }

    private void addLatestNews(Model model){
        int numbersOfNews = 5;
        List<News> newslist = serviceNews.getLatestNews(numbersOfNews);
        model.addAttribute("LatestNewsList", newslist);
    }
}
