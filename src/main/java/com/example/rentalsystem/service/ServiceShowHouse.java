package com.example.rentalsystem.service;

import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.repository.ShowHouseSQL;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public List<House> getAllSpecificKindHouse(int id){
        return showHouseSQL.getAllSpecificKindHouse(id);
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

