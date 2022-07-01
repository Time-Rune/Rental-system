package com.example.rentalsystem.repository;

import com.example.rentalsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface loginSQL {
    @Select("select * from User where UID=#{account} and UPassword=#{password}")
    List<User> loginUser(String account, String password);
}
