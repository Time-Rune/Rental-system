package com.example.rentalsystem.entity;

import javax.xml.crypto.Data;
import java.util.Date;

public class Admins {
    private int AID;
    private String Aaccount;
    private String Apassword;
    private String Aname;
    private Date date;
    private String Aphone;

    @Override
    public String toString() {
        return "Admins{" +
                "AID=" + AID +
                ", Aaccount='" + Aaccount + '\'' +
                ", Apassword='" + Apassword + '\'' +
                ", Aname='" + Aname + '\'' +
                ", date=" + date +
                ", Aphone='" + Aphone + '\'' +
                '}';
    }

    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

    public String getAaccount() {
        return Aaccount;
    }

    public void setAaccount(String aaccount) {
        Aaccount = aaccount;
    }

    public String getApassword() {
        return Apassword;
    }

    public void setApassword(String apassword) {
        Apassword = apassword;
    }

    public String getAname() {
        return Aname;
    }

    public void setAname(String aname) {
        Aname = aname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAphone() {
        return Aphone;
    }

    public void setAphone(String aphone) {
        Aphone = aphone;
    }
}
