package com.example.rentalsystem.repository;

import com.example.rentalsystem.entity.Admins;
import com.example.rentalsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface loginSQL {
    @Select("select * from User where Uaccount=#{account} and UPassword=#{password}")
    User loginUser(String account, String password);

    @Select("select * from admins where Aaccount = #{account} and Apassword = #{password}")
    Admins loginAdmins(String account, String password);
}
