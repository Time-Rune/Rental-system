package com.example.rentalsystem.repository;

import com.example.rentalsystem.entity.User;
import com.sun.org.apache.xpath.internal.objects.XString;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserSQL {
    @Insert("Insert into User(UID,Uaccount,Upassword,Uname,Usex,Ubirth,Uphone,Uregtime)" +
            "values(#{uid},#{uaccount},#{upassword},#{uname},#{usex},#{ubirth},#{uphone},#{uregtime})")
    void addNewUser(int uid, String uaccount, String upassword, String uname, String usex,
                    String ubirth, String uphone, String uregtime);
    @Select("select * from User where UID = #{uid}")
    List<User> selectUser(int uid);

    @Delete("delete from User where UID = #{uid}")
    void deleteUser(int uid);

    @Update("updata User set Uphoto=#{uphoto} where UID = #{uid}")
    void updateHead(int uid, String uphoto);

    @Update("updata User set Upassword=#{password} where UID = #{uid}")
    void updatePassword(int uid, String password);

    @Update("updata User set Uname=#{name},Usex=#{sex},Ubirth=#{birth},Uphone=#{phone} where UID=#{uid}")
    void updateInformation(int uid, String name, String sex, String birth, String phone);

}
