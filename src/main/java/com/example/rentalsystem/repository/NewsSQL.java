package com.example.rentalsystem.repository;

import com.example.rentalsystem.entity.News;
import org.apache.ibatis.annotations.*;

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

    @Delete("delete * from News where NID = #{id}")
    void deleteNews(int id);

    @Select("select * from News where NID = #{id}")
    List<News> getNewsByID(int id);

    @Select("select * from News")
    List<News> getAllNews();

    @Update("update News set Npost=#{post},Nheader=#{header},Ndate=#{date},Nclick=#{click} where NID=#{id}")
    void updateNews(int id, int post, String header, String date, int click);

    @Select("select * from News where NID like #{key} or Nheader like #{key} or Npost like #{key} " +
            "or Ndate like #{key} or Nclick like #{key}")
    List<News> searchNews(String key);

}
