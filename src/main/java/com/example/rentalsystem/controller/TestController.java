package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.entity.Word;
import com.example.rentalsystem.service.ServiceShowHouse;
import com.example.rentalsystem.service.ServiceWord;
import com.example.rentalsystem.utils.Province;
import com.example.rentalsystem.utils.ShowWord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("/demo")
public class TestController {
    @Autowired
    private ServiceShowHouse serviceShowHouse;
    @Autowired
    private ServiceWord serviceWord;

//    @GetMapping("/submittext")
    @RequestMapping("/submittext")
    public String submitText(Model model){
        User user = serviceWord.getPosterByID();
        String photo = user.getUphoto();
        String name = user.getUname();
        List<ShowWord> showWordList = new ArrayList<>();
        List<Word> wordList = serviceWord.getPerPageWords(1, 10);
        for(Word word: wordList){
            ShowWord showWord = new ShowWord(name, photo, word.getWtext());
            showWordList.add(showWord);
            System.out.println(showWord.toString());
        }
        model.addAttribute("wordList", showWordList);
        return "/temp/submit_text";
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
            ShowWord showWord = new ShowWord(name, photo, word.getWtext());
            showWordList.add(showWord);
            System.out.println(showWord.toString());
        }
        modelAndView.addObject("wordList", showWordList);
        return modelAndView;
    }
//    @RequestMapping(value = "/freshdata")
//    public ModelAndView freshData(HttpServletRequest request, HttpServletResponse response){
//        ModelAndView modelAndView = new ModelAndView("/demo/submit_text::wordTable");
//        List<ShowWord> showWordList = new ArrayList<>();
//        List<Word> wordList = serviceWord.getPerPageWords(1, 5);
//        for(Word word: wordList){
//            User user = serviceWord.getPosterByID();
//            String photo = user.getUphoto();
//            String name = user.getUname();
//            ShowWord showWord = new ShowWord(name, photo, word.getWtext());
//            showWordList.add(showWord);
//        }
//        modelAndView.addObject("showWordList", showWordList);
//        return modelAndView;
//    }
}
