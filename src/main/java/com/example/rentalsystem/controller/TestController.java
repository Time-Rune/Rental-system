package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.service.ServiceShowHouse;
import com.example.rentalsystem.utils.Province;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("/demo")
public class TestController {
    @Autowired
    private ServiceShowHouse serviceShowHouse;

//    @GetMapping("/submittext")
    @RequestMapping("/submittext")
    public String submitText(HttpServletRequest request, HttpServletResponse response, Model model){

        return "/temp/submit_text";
    }

    @RequestMapping(value = "/processdata", method = RequestMethod.POST, produces = "application/json")
    public void processData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String htmltext = request.getParameter("Text");
        System.out.println("HtmlText: " + htmltext);
        Enumeration<String> paramName = request.getParameterNames();
        String param = paramName.nextElement();
        System.out.println("param: " + param);

    }
}
