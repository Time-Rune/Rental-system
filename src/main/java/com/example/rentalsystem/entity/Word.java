package com.example.rentalsystem.entity;

import java.util.Date;

public class Word {
    private int WID;
    private String Wtext;
    private String Wpost;
    private Date Wdate;
    private int Wclick;

    @Override
    public String toString() {
        return "Word{" +
                "WID=" + WID +
                ", Wtext='" + Wtext + '\'' +
                ", Wpost='" + Wpost + '\'' +
                ", Wdate=" + Wdate +
                ", Wclick=" + Wclick +
                '}';
    }

    public int getWID() {
        return WID;
    }

    public void setWID(int WID) {
        this.WID = WID;
    }

    public String getWtext() {
        return Wtext;
    }

    public void setWtext(String wtext) {
        Wtext = wtext;
    }

    public String getWpost() {
        return Wpost;
    }

    public void setWpost(String wpost) {
        Wpost = wpost;
    }

    public Date getWdate() {
        return Wdate;
    }

    public void setWdate(Date wdate) {
        Wdate = wdate;
    }

    public int getWclick() {
        return Wclick;
    }

    public void setWclick(int wclick) {
        Wclick = wclick;
    }
}
