package com.example.rentalsystem.service;

import com.example.rentalsystem.entity.Admins;
import com.example.rentalsystem.repository.AdminSQL;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServiceAdmin {
    @Resource
    private AdminSQL adminSQL;


}
