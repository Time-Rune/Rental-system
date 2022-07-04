package com.example.rentalsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class House {
    private int HID;
    private String Hname;
    private int Hkind;
    private int Hcost;
    private String Hphoto;
    private int Harea;
    private int Hfloor;
    private int Hdirection;
    private String Hintroduce;
    private int Hstate;
    private int Hclick;
    private int Howner;
    private String Hdate;

}
