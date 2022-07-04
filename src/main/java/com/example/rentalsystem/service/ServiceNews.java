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
        return showNews.get(0);
    }

    public List<News> getAllNews(){
        return newsSQL.getAllNews();
    }

    public void deleteNews(int id){
        newsSQL.deleteNews(id);
    }

    public void updateNews(int id, int post, String header, String date, int click){
        newsSQL.updateNews(id, post, header, date, click);
    }

    public List<News> searchNews(String key){
        String key0 = "%" + key + "%";
        return newsSQL.searchNews(key0);
    }
}
