package com.example.rentalsystem.service;

import com.example.rentalsystem.entity.News;
import com.example.rentalsystem.repository.NewsSQL;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServiceNews {
    @Resource
    private NewsSQL newsSQL;

    public List<News> getLatestNews(int num){
        return newsSQL.selectNews(num);
    }

    public News getNewsByID(int id){
        List<News> showNews = newsSQL.getNewsByID(id);
        News news = showNews.get(0);
        return news;
    }
}
