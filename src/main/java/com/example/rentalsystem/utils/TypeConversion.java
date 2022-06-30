package com.example.rentalsystem.utils;

public class TypeConversion {
    static public String changeNumberToHouseType(int num){
        if(num == 0)
            return "商业办公";
        if(num == 1)
            return "普通民宅";
        if(num == 2)
            return "酒店式公寓";
        return "error";
    }
    static public int changeHouseTypeToNumber(String name){
        if(name.equals("商业办公"))
            return 0;
        if(name.equals("普通民宅"))
            return 1;
        if(name.equals("酒店式公寓"))
            return 2;
        return -1;
    }
}
