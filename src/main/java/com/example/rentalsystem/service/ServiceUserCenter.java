package com.example.rentalsystem.service;

import com.example.rentalsystem.entity.Contract;
import com.example.rentalsystem.entity.House;
import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.repository.ContractSQL;
import com.example.rentalsystem.repository.ShowHouseSQL;
import com.example.rentalsystem.repository.UserSQL;
import com.example.rentalsystem.utils.UserContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ServiceUserCenter {
    @Resource
    private UserSQL userSQL;
    @Resource
    private ShowHouseSQL showHouseSQL;
    @Resource
    private ContractSQL contractSQL;

    public User getUserInfo(){
        return UserContext.getCurrentUser();
    }

    public void updateUserInfo(User newUser){

    }

    public boolean checkCurrentUserPassword(String inputPassword){
        User user = getUserInfo();
        System.out.println("当前用户：" + user.getUname() + " 用户密码：" + user.getUpassword());
        System.out.println("新密码为：" + inputPassword);
        if(inputPassword.equals(user.getUpassword()))
            return true;
        return false;
    }

    public boolean updateCurrentUerPassword(String oldPassword, String inputPassword){
        if(!checkCurrentUserPassword(oldPassword))
            return false;
        User user = getUserInfo();
        userSQL.updatePassword(user.getUID(), inputPassword);
        return true;
    }

    public boolean submitHouse(House house){
        User user = getUserInfo();
        try{
            showHouseSQL.insertHouse(house.getHID(), house.getHname(), house.getHkind(),
                    house.getHcost(), house.getHarea(), house.getHfloor(), house.getHdirection(),
                    house.getHowner(), house.getHdate());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<House> getMyHouse() {
        int id = getUserInfo().getUID();
        return showHouseSQL.getHouseByOwnerID(id);
    }

    public List<Contract> showMyContract(){
        int id = getUserInfo().getUID();
        return contractSQL.getMyContract(id);
    }

    public boolean submitContract(int CID, String house, String photoURL, String beginDate, String endDate){
        String line = house;
        String regex = "房屋ID：([0-9]*)；房屋名：(.*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        int HID;
        if(matcher.find()){
            try {
                System.out.println(matcher.group(1));
                HID = Integer.parseInt(matcher.group(1));
                contractSQL.insertContract(CID, photoURL, beginDate, endDate, HID);
                return true;
            }catch (IllegalStateException e){
                System.out.println("未匹配到字符串");
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
