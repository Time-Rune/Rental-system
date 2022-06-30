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

    public List<House> getAllSpecificKindHouse(int id){
        return showHouseSQL.getAllSpecificKindHouse(id);
    }

    public List<House> getHouseByID(int id){
        return showHouseSQL.getHouseByID(id);
    }

    public List<House> getAllHouse(){
        return showHouseSQL.getAllHouse();
    }
}

