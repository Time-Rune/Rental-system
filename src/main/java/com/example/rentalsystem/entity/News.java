package com.example.rentalsystem.entity;

import java.util.Date;

public class News {
    private int NID;
    private String Ntext;
    private String Npost;
    private Date Ndate;
    private int Nclick;
    private String Nheader;

    @Override
    public String toString() {
        return "News{" +
                "NID=" + NID +
                ", Ntext='" + Ntext + '\'' +
                ", Npost='" + Npost + '\'' +
                ", Ndate=" + Ndate +
                ", Nclick=" + Nclick +
                ", Nheader='" + Nheader + '\'' +
                '}';
    }

    public String getNheader() {
        return Nheader;
    }

    public void setNheader(String nheader) {
        Nheader = nheader;
    }

    public int getNID() {
        return NID;
    }

    public void setNID(int NID) {
        this.NID = NID;
    }

    public String getNtext() {
        return Ntext;
    }

    public void setNtext(String ntext) {
        Ntext = ntext;
    }

    public String getNpost() {
        return Npost;
    }

    public void setNpost(String npost) {
        Npost = npost;
    }

    public Date getNdate() {
        return Ndate;
    }

    public void setNdate(Date ndate) {
        Ndate = ndate;
    }

    public int getNclick() {
        return Nclick;
    }

    public void setNclick(int nclick) {
        Nclick = nclick;
    }
}
