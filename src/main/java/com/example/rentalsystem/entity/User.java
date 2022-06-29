package com.example.rentalsystem.entity;

import java.util.Date;

public class User {
    private int UID;
    private String Uaccount;
    private String Upassword;
    private String Uname;
    private String Usex;
    private Date Ubirth;
    private String Uphone;
    private String Uphoto;
    private String Uregtime;

    @Override
    public String toString() {
        return "User{" +
                "UID=" + UID +
                ", Uaccount='" + Uaccount + '\'' +
                ", Upassword='" + Upassword + '\'' +
                ", Uname='" + Uname + '\'' +
                ", Usex='" + Usex + '\'' +
                ", Ubirth=" + Ubirth +
                ", Uphone='" + Uphone + '\'' +
                ", Uphoto='" + Uphoto + '\'' +
                ", Uregtime='" + Uregtime + '\'' +
                '}';
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getUaccount() {
        return Uaccount;
    }

    public void setUaccount(String uaccount) {
        Uaccount = uaccount;
    }

    public String getUpassword() {
        return Upassword;
    }

    public void setUpassword(String upassword) {
        Upassword = upassword;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUsex() {
        return Usex;
    }

    public void setUsex(String usex) {
        Usex = usex;
    }

    public Date getUbirth() {
        return Ubirth;
    }

    public void setUbirth(Date ubirth) {
        Ubirth = ubirth;
    }

    public String getUphone() {
        return Uphone;
    }

    public void setUphone(String uphone) {
        Uphone = uphone;
    }

    public String getUphoto() {
        return Uphoto;
    }

    public void setUphoto(String uphoto) {
        Uphoto = uphoto;
    }

    public String getUregtime() {
        return Uregtime;
    }

    public void setUregtime(String uregtime) {
        Uregtime = uregtime;
    }
}
