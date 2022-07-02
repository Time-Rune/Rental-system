package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.service.ServiceLogin;
import com.example.rentalsystem.utils.AjaxResult;
import com.example.rentalsystem.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private ServiceLogin serviceLogin;

    @GetMapping("/login")
    public String login(String test){
        System.out.println(test);
        return "test";
    }

    @RequestMapping(value = "/loginsubmit", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public AjaxResult loginController(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("success!");
        String username = request.getParameter("act");
        String password = request.getParameter("psw");
        System.out.println("username = " + username + " password = " + password);
        AjaxResult ajaxResult = new AjaxResult();
        User user = (User) serviceLogin.loginService(username, password);
        if(user == null){
            ajaxResult.setMsg("用户名或密码错误");
            System.out.println("用户名或密码错误");
        }else{
            System.out.println("登录成功");
            UserContext.putCurrentUserIntoSession(user);
            response.getWriter().print(UserContext.getCurrentInfo().toString());
        }
        return ajaxResult;
    }
}