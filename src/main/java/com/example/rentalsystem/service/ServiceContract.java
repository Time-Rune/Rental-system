package com.example.rentalsystem.service;

import com.example.rentalsystem.entity.Contract;
import com.example.rentalsystem.repository.ContractSQL;
import com.example.rentalsystem.utils.UserContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServiceContract {
    @Resource
    private ContractSQL contractSQL;

    public void addContract(int uid1, int uid2, int hid, String begin, String end){
        int newid = contractSQL.getMaxCID() + 1;
        contractSQL.insertContractUser(newid, uid1, uid2, begin, end, hid);
    }

    public void updateContract(int id, int uid1, int uid2, String begin, String end, int hid){
        contractSQL.updateContract(id, uid1, uid2, begin, end, hid);
    }

    public void deleteContract(int id){
        contractSQL.deleteContract(id);
    }

    public List<Contract> selectAllContract(){
        return  contractSQL.getContract();
    }

    public List<Contract> searcthConstract(String key){
        String key0 = "%" + key + "%";
        return contractSQL.searchContract(key0);
    }

    public List<Contract> showMyContract(){
        int userid = UserContext.getCurrentUser().getUID();
        return contractSQL.getMyContract(userid);
    }

}
