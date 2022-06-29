package com.example.rentalsystem.repository;

import com.example.rentalsystem.entity.House;
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

    @Select("select * from house where house.Hkind = #{kind}")
    List<House> getSpecificKindHouse(int kind);
}
