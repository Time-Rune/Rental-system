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

    public List<House> getSpecificKindHouse(int num){
        return showHouseSQL.getSpecificKindHouse(num);
    }
}

