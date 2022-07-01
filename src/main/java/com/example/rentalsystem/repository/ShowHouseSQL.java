package com.example.rentalsystem.repository;

import com.example.rentalsystem.entity.House;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface ShowHouseSQL {
//    @Select("select * from house where house.Hdate > #{nowtime}")
//    List<House> getLatestHouse(String nowtime);

    @Select("select * from House order by House.Hdate desc limit #{sum}")
    List<House> getLatestHouse(int sum);

    @Select("select * from house where house.Hkind = #{kind} order by House.Hdate desc limit #{sum}")
    List<House> getSpecificKindHouse(int kind, int sum);

    @Select("select * from house where house.Hkind = #{kind} order by House.Hdate desc limit #{sum}")
    List<House> getAllSpecificKindHouse(int kind);

    @Select("select * from house where Hname like #{keyword}")
    List<House> searchHouseByName(String keyword);

    @Select("select max(House.HID) from House")
    int getMaxHID();

    @Select("select * from house where HID = #{id}")
    List<House> getHouseByID(int id);

    @Select("select * from house")
    List<House> getAllHouse();

}
