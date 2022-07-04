package com.example.rentalsystem.repository;

import com.example.rentalsystem.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;


@Mapper
public interface UserSQL {
    // 插入一个用户
    @Insert("Insert into User(UID,Uaccount,Upassword,Uname,Usex,Ubirth,Uphoto,Uphone,Uregtime)" +
            "values(#{uid},#{uaccount},#{upassword},#{uname},#{usex},#{ubirth}," +
            "'src/main/resources/static/其他默认图.jpeg',#{uphone},#{uregtime})")
    void addNewUser(int uid, String uaccount, String upassword, String uname, String usex,
                    String ubirth, String uphone, String uregtime);

    @Select("select * from User where UID like #{key} or Uaccount like #{key} or Upassword like #{key} or " +
            "Uname like #{key} or Usex like #{key} or Uphone like #{key}")
    List<User> searchUser(String key);

    @Select("select * from User where UID = #{uid}")
    List<User> selectUser(int uid);

    @Select("select * from User")
    List<User> selectAllUser();

    @Select("select max(User.UID) from User")
    int getMaxUID();

    @Delete("delete from User where UID = #{uid}")
    void deleteUser(int uid);

    @Update("update User set Uphoto=#{uphoto} where UID = #{uid}")
    void updateHead(int uid, String uphoto);

    // 修改密码
    @Update("update User set Upassword=#{password} where UID = #{uid}")
    void updatePassword(int uid, String password);

    @Update("update User set Uaccount=#{account} where UID = #{uid}")
    void updateAccount(int uid, String account);

    // 修改名称，性别，生日，电话
    @Update("update User set Uname=#{name},Usex=#{sex},Ubirth=#{birth},Uphone=#{phone} where UID=#{uid}")
    void updateInformation(int uid, String name, String sex, String birth, String phone);

    @Select("select * from user where UID=#{id}")
    List<User> getUserByID(int id);

}
