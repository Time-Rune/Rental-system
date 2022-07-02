package com.example.rentalsystem.service;

import com.example.rentalsystem.repository.SignUpSQL;
import com.example.rentalsystem.repository.UserSQL;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ServiceSignUp {
    @Autowired
    UserSQL userSQL;

    public void addNewUser(String account, String password, String name, String sex, String birthdate, String phone, String photo){
        int id = userSQL.getMaxUID() + 1;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String regtime = simpleDateFormat.format(new Date().getTime());
        userSQL.addNewUser(id, account, password, name, sex, birthdate, phone, regtime);
    }
}
