package com.example.rentalsystem.repository;

import com.example.rentalsystem.entity.House;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface ShowHouseSQL {
//    @Select("select * from house where house.Hdate > #{nowtime}")
//    List<House> getLatestHouse(String nowtime);
    @Insert("Insert into House(HID,Hname,Hkind,Hcost,Harea,Hfloor,Hdirection,Howner,Hdate) " +
            "values(#{id},#{name},#{kind},#{cost},#{area},#{direct},#{owner},#{date})")
    void insertHouse(int id, String name, int kind, int cost, int area, int floor, int direct, int owner, String date);

    @Update("Update House set Hname=#{name},Hkind=#{kind},Hcost=#{cost},Harea=#{area}," +
            "Hfloor=#{floor}, Hdirection=#{direct},Howner=#{owner}")
    void updateHouse(String name, int kind, int cost, int area, int floor, int direct, int owner);

    @Delete("delete * from House where HID = #{id}")
    void deleteHouse(int id);

    @Select("select * from House order by House.Hdate desc limit #{sum}")
    List<House> getLatestHouse(int sum);

    @Select("select * from house where house.Hkind = #{kind} order by House.Hdate desc limit #{sum}")
    List<House> getSpecificKindHouse(int kind, int sum);

    @Select("select * from house where house.Hkind = #{kind} order by House.Hdate desc limit #{sum}")
    List<House> getAllSpecificKindHouse(int kind);

    @Select("select * from house order by House.Hclick desc limit #{sum}")
    List<House> getHotHouse(int sum);

    @Select("select * from house where Hname like #{keyword}")
    List<House> searchHouseByName(String keyword);

    @Select("select * from house where HID like #{key} or Hname like ${key} or Hkind like #{key} " +
            "or Hcost like #{key} or Howner like #{key}")
    List<House> searchHouse(String key);

    @Select("select max(House.HID) from House")
    int getMaxHID();

    @Select("select * from house where HID = #{id}")
    List<House> getHouseByID(int id);

    @Select("select * from house")
    List<House> getAllHouse();

    @Update("update house set house.Hclick=house.Hclick+1 where HID=#{id}")
    void increaseHouseHclick(int id);

}
