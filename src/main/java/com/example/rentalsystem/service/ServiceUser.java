package com.example.rentalsystem.service;

import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.repository.UserSQL;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ServiceUser {
    @Resource
    private UserSQL userSQL;

    public List<User> selectUser(int num){
        return userSQL.selectUser(num);
    }

    public List<User> selectAllUser(){
        return userSQL.selectAllUser();
    }

    public void insertUser(String account, String pass, String uname){
        Date date = new Date(100000);
        userSQL.addNewUser(10, account + "error", pass + "error", uname + "error", "男",
                "2022-2-14", "12345", "2022-2-11");
    }

    public void deleteUser(int id){
        userSQL.deleteUser(id);
    }

}
