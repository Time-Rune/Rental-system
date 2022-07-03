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

public class Word {
    private int WID;
    private String Wtext;
    private int Wpost;
    private Date Wdate;
    private int Wclick;
}
