package com.example.rentalsystem.repository;

import com.example.rentalsystem.entity.Contract;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface ContractSQL {
    @Insert("insert into Contract(CID, Cphoto, UID1, UID2, Ubegin, Uend, Hid)" +
            "values(#{id}, #{photo}, #{uid1}, #{uid2}, #{begin}, #{end}, #{hid})")
    void insertContract(int id, String photo, int uid1, int uid2, Date begin, Date end, int hid);

    @Select("select * from Contract")
    List<Contract> getContract();

    @Delete("delete from Contract where CID = #{id}")
    void deleteContract(int id);

}
