package com.example.rentalsystem.controller;

import com.example.rentalsystem.entity.Contract;
import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.repository.ShowHouseSQL;
import com.example.rentalsystem.service.ServiceContract;
import com.example.rentalsystem.service.ServiceShowHouse;
import com.example.rentalsystem.service.ServiceUserCenter;
import com.example.rentalsystem.utils.AjaxResult;
import com.example.rentalsystem.utils.TypeConversion;
import com.example.rentalsystem.utils.UserContext;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/usercenter")
public class UserCenterController {
    @Autowired
    ServiceUserCenter serviceUserCenter;
    @Autowired
    ShowHouseSQL showHouseSQL;
    @Autowired
    ServiceContract serviceContract;
    @Autowired
    ServiceShowHouse serviceShowHouse;

    @GetMapping("/center")
    public String userCenter(Model model){
        User user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        List<Contract> myContractList = serviceContract.showMyContract();
//        for(Contract contract: myContractList){
//            System.out.println(contract.toString());
//        }
        model.addAttribute("myContractList", myContractList);
        List<House> houses = serviceShowHouse.getMyHouse(user.getUID());
        model.addAttribute("myHouseList", houses);
        return "/user";
    }
//个人信息修改
    @RequestMapping(value = "/userinfo", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult updateUserInfo(HttpServletRequest request, HttpServletResponse response, Model model){
        User user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        String name = request.getParameter("infoNickname");
        String sex = request.getParameter("infoSex");
        String date = request.getParameter("infoBirth");
        String phone = request.getParameter("infoQQ");
        String photo = request.getParameter("infoHeadPicture");
        user.setUname(name);
        user.setUsex(sex);
        user.setUbirth(date);
        user.setUphone(phone);
        user.setUphoto(photo);
        AjaxResult ajaxResult = new AjaxResult();
        try {
            serviceUserCenter.updateUserInfo(user);
            UserContext.removeCurrentUser();
            UserContext.putCurrentUserIntoSession(user);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setMsg("1");
        }
        return ajaxResult;
    }
//    修改密码
    @RequestMapping(value = "updatepassword", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public AjaxResult updatePassword(HttpServletRequest request){
        String oldPassword = request.getParameter("oldpsw");
        String newPassword = request.getParameter("newpsw");
        boolean flag = serviceUserCenter.updateCurrentUerPassword(oldPassword, newPassword);
        AjaxResult ajaxResult = new AjaxResult();
        if(flag){
            ajaxResult.setMsg("1");
            System.out.println("密码修改成功，新密码为：" + newPassword);
        }
        else{
            System.out.println("密码修改失败！");
            ajaxResult.setMsg("0");
        }
        return ajaxResult;
    }
//发布房源
    @RequestMapping(value = "submithouse", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public AjaxResult submitHouse(HttpServletRequest request){
        String name = request.getParameter("housename");
        int kind = TypeConversion.changeHouseTypeToNumber(request.getParameter("housetype"));
        int cost = Integer.parseInt(request.getParameter("housecost"));
        String photo = request.getParameter("housepicture");
        int area = Integer.parseInt(request.getParameter("housearea"));
        int floor = Integer.parseInt(request.getParameter("housefloor"));
        int direct = TypeConversion.changeDirectionTypeToNumber(request.getParameter("housedirect"));
        String text = request.getParameter("housetext");
        int id = showHouseSQL.getMaxHID() + 1;
        int userid = UserContext.getCurrentUser().getUID();
        String nowtime = new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime());
        House house = new House(id, name, kind, cost, photo, area, floor, direct, text, 0, 0, userid, nowtime);
        serviceShowHouse.insertHouseByHouse(house);
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setMsg("1");
        return ajaxResult;
    }
//用户退出
    @GetMapping(value = "userexit")
    public void exitUser(){
        UserContext.removeCurrentUser();
    }
}
