package com.example.rentalsystem.repository;

import com.example.rentalsystem.entity.Admins;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface AdminSQL {
    @Insert("insert into Admins(AID, Aaccount, Apassword, Aname, Adate, Aphone)" +
            "values(#{id}, #{account}, #{password}, #{name}, #{date}, #{phone})")
    void insertAdmin(int id, String account, String password, String name, String date, String phone);

    @Update("update Admins set Aaccount=#{account},Apassword=#{password},Aname=#{name},Aphone=#{phone} where AID=#{id}")
    void updateAdmin(int id, String account, String password, String name, String phone);

    @Select("select * from Admins")
    List<Admins> getAdmins();

    @Select("select max(Admins.AID) from Admins")
    int getMaxAID();

    @Delete("delete from Admins where AID = #{id}")
    void deleteAdmin(int id);
}
