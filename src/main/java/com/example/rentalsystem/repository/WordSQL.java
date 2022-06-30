package com.example.rentalsystem.repository;

import com.example.rentalsystem.entity.Word;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface WordSQL {
    @Insert("insert into Word(WID, Wtext, Wpost, Wdate, Wclick) " +
            "values(#{wid}, #{text}, #{post}, #{date}, #{click})")
    void insertWord(int wid, String text, int post, Date date, int click);

    @Select("select * from Word")
    List<Word> getWords();

    @Select("select max(Word.WID) from Word")
    int getMaxWID();

    @Delete("delete from Word where WID = #{id}")
    void deleteWord(int id);

}
