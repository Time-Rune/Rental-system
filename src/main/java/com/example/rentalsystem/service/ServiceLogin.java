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

    public User loginService(String username, String password){
        List<User> list = loginSQL.loginUser(username, password);
        User user = list.get(0);
        return user;
    }
}
