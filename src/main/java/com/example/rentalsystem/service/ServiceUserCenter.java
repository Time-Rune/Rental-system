package com.example.rentalsystem.service;

import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.repository.UserSQL;
import com.example.rentalsystem.utils.UserContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ServiceUserCenter {
    @Resource
    private UserSQL userSQL;

    public User getUserInfo(){
        return UserContext.getCurrentUser();
    }

    public void updateUserInfo(User newUser){

    }

    public boolean checkCurrentUserPassword(String inputPassword){
        User user = getUserInfo();
        if(inputPassword.equals(user.getUpassword()))
            return true;
        return false;
    }

    public boolean updateCurrentUerPassword(String inputPassword){
        if(!checkCurrentUserPassword(inputPassword))
            return false;
//        userSQL.updatePassword(inputPassword);
        return true;
    }
}
