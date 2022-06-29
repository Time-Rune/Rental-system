package com.example.rentalsystem.repository;

import com.example.rentalsystem.entity.Admins;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface AdminSQL {
    @Insert("insert into Admins(AID, Aaccount, Apassword, Aname, Adate, Aphone)" +
            "values(#{id}, #{account}, #{password}, #{name}, #{date}, #{phone})")
    void insertAdmin(int id, String account, String password, String date, String phone);

    @Select("select * from Admins")
    List<Admins> getAdmins();

    @Delete("delete from Admins where AID = #{id}")
    void deleteAdmin(int id);
}
