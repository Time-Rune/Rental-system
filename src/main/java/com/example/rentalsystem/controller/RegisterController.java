package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.Admins;
import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.service.ServiceLogin;
import com.example.rentalsystem.service.ServiceUser;
import com.example.rentalsystem.utils.AjaxResult;
import com.example.rentalsystem.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class RegisterController {
    @Autowired
    private ServiceUser serviceUser;

    @GetMapping("/register")
    public String login(String test){
        System.out.println(test);
        return "test";
    }

    @RequestMapping(value = "Registersubmit", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public AjaxResult loginController(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("success!");
        String useremail = request.getParameter("email");
        String username = request.getParameter("act");
        String password = request.getParameter("pwd");
        System.out.println(" useremail = " + useremail + "username = " + username + " password = " + password);
        AjaxResult ajaxResult = new AjaxResult();

        if(useremail.length() == 0 || username.length() == 0 || password.length() == 0){
            ajaxResult.setMsg("empty");
            System.out.println("Error，账号或用户名或密码为空");
        }
        else{
            serviceUser.insertUser(useremail, password, username, "男", "1990-01-01", "");
            ajaxResult.setMsg("userReg");
            System.out.println("用户注册成功");
        }
        return ajaxResult;
    }
}
//注册将信息插入到数据库代码
//        if(role.equals("user")){
//            AjaxResult ajaxResult = new AjaxResult();
//            User user = (User) serviceLogin.loginService(useremail, username, password);
//            if(user == null){
//                ajaxResult.setMsg("error");
//                System.out.println("管理员昵称或密码错误");
//            }else{
//                ajaxResult.setMsg("user");
//                System.out.println("管理员登录成功");
//                UserContext.removeCurrentUser();
//                UserContext.putCurrentUserIntoSession(user);
//                //            response.getWriter().print(UserContext.getCurrentInfo().toString());
//            }
//            return ajaxResult;
//        }
//        else{
//            AjaxResult ajaxResult = new AjaxResult();
//            Admins admins = (Admins) serviceRegister.loginService(username, password, role);
//            if(admins == null){
//                ajaxResult.setMsg("error");
//                System.out.println("管理员用户名或密码错误");
//            }
//            else{
//                ajaxResult.setMsg("admin");
//                System.out.println("管理员登录成功");
//            }
//            return ajaxResult;
//        }
//    }

//    @GetMapping("/logintest")
//    public String loginTest(Model model){
//        return "/temp/index";
//    }
//}
