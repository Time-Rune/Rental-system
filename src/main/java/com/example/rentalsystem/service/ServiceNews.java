package com.example.rentalsystem.service;

import com.example.rentalsystem.entity.News;
import com.example.rentalsystem.repository.NewsSQL;

import javax.annotation.Resource;
import java.util.List;

public class ServiceNews {
    @Resource
    private NewsSQL newsSQL;

    public List<News> getLatestNews(int num){
        return newsSQL.selectNews(num);
    }
}
