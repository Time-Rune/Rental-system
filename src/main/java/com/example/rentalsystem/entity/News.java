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
public class News {
    private int NID;
    private String Ntext;
    private String Npost;
    private String Ndate;
    private int Nclick;
    private String Nheader;

}
