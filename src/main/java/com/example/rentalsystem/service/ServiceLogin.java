package com.example.rentalsystem.service;

import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.repository.loginSQL;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServiceLogin {
    @Resource
    loginSQL loginSQL;

    public Object loginService(String username, String password){
        List<User> list = loginSQL.loginUser(username, password);
        Object res;
        try {
            User user = list.get(0);
            res = user;
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            res = null;
        }
        return res;
    }
}
