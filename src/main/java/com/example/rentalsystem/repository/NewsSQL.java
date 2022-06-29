package com.example.rentalsystem.repository;

import com.example.rentalsystem.entity.News;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface NewsSQL {
    @Select("select * from News order by News.Ndate desc limit #{sum}")
    List<News> selectNews(int sum);

    @Select("SELECT max(News.NID) FROM News")
    int getMaxNID();

    @Insert("insert into News(NID, Ntext, Nheader, Npost, Ndate, Nclick) " +
            "values(#{id}, #{text}, #{header}, #{post}, #{date}, #{click})")
    void insertNews(int id, String text, String header, int post, Date date, int click);

    @Delete("delete from News where NID = #{id}")
    void deleteNews(int id);


}
