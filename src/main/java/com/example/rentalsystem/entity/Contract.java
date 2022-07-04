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

public class Contract {
    private int CID;
    private String Cphoto;
    private int UID1;
    private int UID2;
    private String Ubegin;
    private String Uend;
    private int HID;
}
