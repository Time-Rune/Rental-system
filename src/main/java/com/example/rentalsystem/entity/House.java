package com.example.rentalsystem.entity;

import java.util.Date;

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
    private Date Hdate;

    @Override
    public String toString() {
        return "House{" +
                "HID=" + HID +
                ", Hname='" + Hname + '\'' +
                ", Hkind=" + Hkind +
                ", Hcost=" + Hcost +
                ", Hphoto='" + Hphoto + '\'' +
                ", Harea=" + Harea +
                ", Hfloor=" + Hfloor +
                ", Hdirection=" + Hdirection +
                ", Hintroduce='" + Hintroduce + '\'' +
                ", Hstate=" + Hstate +
                ", Hclick=" + Hclick +
                ", Howner=" + Howner +
                ", Hdate=" + Hdate +
                '}';
    }

    public int getHID() {
        return HID;
    }

    public void setHID(int HID) {
        this.HID = HID;
    }

    public String getHname() {
        return Hname;
    }

    public void setHname(String hname) {
        Hname = hname;
    }

    public int getHkind() {
        return Hkind;
    }

    public void setHkind(int hkind) {
        Hkind = hkind;
    }

    public int getHcost() {
        return Hcost;
    }

    public void setHcost(int hcost) {
        Hcost = hcost;
    }

    public String getHphoto() {
        return Hphoto;
    }

    public void setHphoto(String hphoto) {
        Hphoto = hphoto;
    }

    public int getHarea() {
        return Harea;
    }

    public void setHarea(int harea) {
        Harea = harea;
    }

    public int getHfloor() {
        return Hfloor;
    }

    public void setHfloor(int hfloor) {
        Hfloor = hfloor;
    }

    public int getHdirection() {
        return Hdirection;
    }

    public void setHdirection(int hdirection) {
        Hdirection = hdirection;
    }

    public String getHintroduce() {
        return Hintroduce;
    }

    public void setHintroduce(String hintroduce) {
        Hintroduce = hintroduce;
    }

    public int getHstate() {
        return Hstate;
    }

    public void setHstate(int hstate) {
        Hstate = hstate;
    }

    public int getHclick() {
        return Hclick;
    }

    public void setHclick(int hclick) {
        Hclick = hclick;
    }

    public int getHowner() {
        return Howner;
    }

    public void setHowner(int howner) {
        Howner = howner;
    }

    public Date getHdate() {
        return Hdate;
    }

    public void setHdate(Date hdate) {
        Hdate = hdate;
    }
}
