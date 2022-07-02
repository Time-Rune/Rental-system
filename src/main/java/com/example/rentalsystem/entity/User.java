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

public class User {
    private int UID;
    private String Uaccount;
    private String Upassword;
    private String Uname;
    private String Usex;
    private String Ubirth;
    private String Uphone;
    private String Uphoto;
    private String Uregtime;

}
