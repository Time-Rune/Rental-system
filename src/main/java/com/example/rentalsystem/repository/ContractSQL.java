package com.example.rentalsystem.repository;

import com.example.rentalsystem.entity.Contract;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface ContractSQL {
    @Insert("insert into Contract(CID, Cphoto, UID1, UID2, Ubegin, Uend, Hid)" +
            "values(#{id}, 'src/main/resources/static/default.jpeg', #{uid1}, #{uid2}, #{begin}, #{end}, #{hid})")
    void RuneinsertContract(int id, int uid1, int uid2, String begin, String end, int hid);

    @Select("select * from Contract")
    List<Contract> getContract();

    @Select("select * from Contract where CID like #{key} or UID1 like #{key} or UID2 like #{key} or " +
            "Hid like #{key} or Ubegin like #{key} or Uend like #{key}")
    List<Contract> searchContract(String key);

    @Select("select * from Contract where UID1 = #{id} or UID2 = #{id}")
    List<Contract> getMyContract(int id);

    @Select("select max(Contract.CID) from Contract")
    int getMaxCID();

    @Insert("insert into contract(CID, Cphoto, UID1, UID2, Ubegin, Uend, HID)" +
            "values(#{CID}, #{Cphoto}, #{UID1}, #{UID2}, #{Ubegin}, #{Uend}, #{HID})")
    void insertContract(int CID, String Cphoto, String Ubegin, String Uend, int HID);

    @Delete("delete from Contract where CID = #{id}")
    void deleteContract(int id);

    @Update("update Contract set UID1=#{uid1},UID2=#{uid2},Ubegin=#{begin},Uend=#{end},HID=#{hid} where CID = #{id}")
    void updateContract(int id, int uid1, int uid2, String begin, String end, int hid);
}
