package com.example.rentalsystem.service;

import com.example.rentalsystem.entity.Admins;
import com.example.rentalsystem.repository.AdminSQL;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ServiceAdmin {
    @Resource
    private AdminSQL adminSQL;

    public List<Admins> selectAllAdmin(){
        return adminSQL.getAdmins();
    }

    public void insertAdmin(String account, String name, String password, String phone){
        int id = adminSQL.getMaxAID() + 1;
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        String nowd = ft.format(date);
        adminSQL.insertAdmin(id, account, password, name, nowd, phone);
    }

    public void updateAdmin(int id, String account, String password, String name, String phone){
        adminSQL.updateAdmin(id, account, password, name, phone);
    }

    public void deleteAdmin(int id){
        adminSQL.deleteAdmin(id);
    }
}
