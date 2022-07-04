package com.example.rentalsystem.service;

import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.repository.loginSQL;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.PatternSyntaxException;

@Service
public class ServiceLogin {
    @Resource
    loginSQL loginSQL;

    public Object loginService(String username, String password, String role){
        Object person;
        if(role.equals("user"))
            person = loginSQL.loginUser(username, password);
        else
            person = loginSQL.loginAdmins(username, password);
        return person;
    }
}
