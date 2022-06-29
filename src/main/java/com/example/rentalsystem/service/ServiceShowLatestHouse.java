package com.example.rentalsystem.service;

import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.repository.ShowHouseSQL;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ServiceShowLatestHouse {
    @Resource
    private ShowHouseSQL showHouseSQL;

    /**
     * 返回最新房屋信息
     * @return 返回二维string数组，格式为：[编号][图片，房屋名称，价格]
     */
    public List<House> getLastestHouse(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowtime = simpleDateFormat.format(date.getTime());
        List<House> houses = showHouseSQL.getLatestHouse(nowtime);
//        String[][] reslist = new String[houses.size()][3];
//        for(int i = 0; i < houses.size(); i++){
//            reslist[i][0] = houses.get(i).getHphoto();
//            reslist[i][1] = houses.get(i).getHname();
//            reslist[i][2] = Integer.toString(houses.get(i).getHcost());
//        }
        return houses;
    }
    public List<House> getLastestHouse(int num){
        List<House> houses = showHouseSQL.getLatestHouse(num);
        return houses;
    }
}
