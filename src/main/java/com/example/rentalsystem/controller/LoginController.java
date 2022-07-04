package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.Admins;
import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.service.ServiceLogin;
import com.example.rentalsystem.utils.AjaxResult;
import com.example.rentalsystem.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "loginsubmit", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public AjaxResult loginController(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("success!");
        String username = request.getParameter("act");
        String password = request.getParameter("psw");
        String role = request.getParameter("role");  //user或admin
        System.out.println("username = " + username + " password = " + password);
        if(role.equals("user")){
            AjaxResult ajaxResult = new AjaxResult();
            User user = (User) serviceLogin.loginService(username, password, role);
            if(user == null){
                ajaxResult.setMsg("error");
                System.out.println("用户用户名或密码错误");
            }else{
                ajaxResult.setMsg("user");
                System.out.println("用户登录成功");
                UserContext.removeCurrentUser();
                UserContext.putCurrentUserIntoSession(user);
    //            response.getWriter().print(UserContext.getCurrentInfo().toString());
            }
            return ajaxResult;
        }
        else{
            AjaxResult ajaxResult = new AjaxResult();
            Admins admins = (Admins) serviceLogin.loginService(username, password, role);
            if(admins == null){
                ajaxResult.setMsg("error");
                System.out.println("管理员用户名或密码错误");
            }
            else{
                ajaxResult.setMsg("admin");
                System.out.println("管理员登录成功");
            }
            return ajaxResult;
        }
    }

    @GetMapping("/logintest")
    public String loginTest(Model model){
        return "/temp/index";
    }
}