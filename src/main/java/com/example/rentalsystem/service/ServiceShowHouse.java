package com.example.rentalsystem.service;

import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.repository.ShowHouseSQL;
import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SplittableRandom;

@Service
public class ServiceShowHouse {
    @Resource
    private ShowHouseSQL showHouseSQL;

    public List<House> getLastestHouse(int num){
        return showHouseSQL.getLatestHouse(num);
    }

    public List<House> getSpecificKindHouse(int id, int num){
        return showHouseSQL.getSpecificKindHouse(id, num);
    }

    public List<House> searchHouseByName(String Keyword){
        String Key0 = "%" + Keyword + "%";
        return showHouseSQL.searchHouseByName(Key0);
    }

    public List<House> searchHouse(String key){
        String Key0 = "%" + key + "%";
        return showHouseSQL.searchHouse(key);
    }

    public List<House> getAllSpecificKindHouse(int id){
        return showHouseSQL.getAllSpecificKindHouse(id);
    }

    public void insertHouse(String name, int kind, int cost, int area, int floor, int direct, int owner){
        int nid = showHouseSQL.getMaxHID() + 1;
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        String nowd = ft.format(date);
        showHouseSQL.insertHouse(nid, name, kind, cost, area, floor, direct, owner, nowd);
    }

    public void updateHouse(String name, int kind, int cost, int area, int floor, int direct, int owner){
        showHouseSQL.updateHouse(name, kind, cost, area, floor, direct, owner);
    }

    public void deleteHouse(int id){
        showHouseSQL.deleteHouse(id);
    }

    public List<House> getHouseByID(int id){
        return showHouseSQL.getHouseByID(id);
    }

    public List<House> getAllHouse(){
        return showHouseSQL.getAllHouse();
    }

    public void increaseHouseHclick(int id){
        showHouseSQL.increaseHouseHclick(id);
    }

    public List<House> getHotHouse(int sum){
        return showHouseSQL.getHotHouse(sum);
    }
}

