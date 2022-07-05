package com.example.rentalsystem.service;

import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.repository.UserSQL;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ServiceUser {
    @Resource
    private UserSQL userSQL;

    public User selectUser(int num){
        return userSQL.selectUser(num);
    }

    public List<User> selectAllUser(){
        return userSQL.selectAllUser();
    }

    public void insertUser(String account, String password, String name, String sex, String birth,
                           String phone){
        int nowid = userSQL.getMaxUID() + 1;
//        Integer nu = null;
//        if(nowid == nu) nowid = 0;else nowid = nowid + 1;
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        String nowd = ft.format(date);
        userSQL.addNewUser(nowid, account, password, name, sex, birth, phone, nowd);
    }

    public void deleteUser(int id){
        userSQL.deleteUser(id);
    }

    public void updateUser(int id, String account, String password, String name, String sex, String birth, String phone){
        userSQL.updateAccount(id, account);
        userSQL.updatePassword(id, password);
        userSQL.updateInformation(id, name, sex, birth, phone);
    }

    public List<User> searchUser(String key){
        String key1 = "%" + key + "%";
        return userSQL.searchUser(key1);
    }
}
