package com.example.rentalsystem.repository;

import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.entity.Word;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface WordSQL {
    @Insert("insert into Word(WID, Wtext, Wpost, Wdate, Wclick, WdetailTime) " +
            "values(#{wid}, #{text}, #{post}, #{date}, #{click}, #{detailTime})")
    void insertWord(int wid, String text, int post, String date, int click, String detailTime);

    @Select("select * from Word order by WdetailTime desc")
    List<Word> getWords();

    @Select("select max(Word.WID) from Word")
    int getMaxWID();

    @Delete("delete from Word where WID = #{id}")
    void deleteWord(int id);

}
