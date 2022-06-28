package com.example.rentalsystem.entity;

import java.util.Date;

public class Contract {
    private int CID;
    private String Cphoto;
    private int UID1;
    private int UID2;
    private Date Ubegin;
    private Date Uend;

    @Override
    public String toString() {
        return "Contract{" +
                "CID=" + CID +
                ", Cphoto='" + Cphoto + '\'' +
                ", UID1=" + UID1 +
                ", UID2=" + UID2 +
                ", Ubegin=" + Ubegin +
                ", Uend=" + Uend +
                '}';
    }

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public String getCphoto() {
        return Cphoto;
    }

    public void setCphoto(String cphoto) {
        Cphoto = cphoto;
    }

    public int getUID1() {
        return UID1;
    }

    public void setUID1(int UID1) {
        this.UID1 = UID1;
    }

    public int getUID2() {
        return UID2;
    }

    public void setUID2(int UID2) {
        this.UID2 = UID2;
    }

    public Date getUbegin() {
        return Ubegin;
    }

    public void setUbegin(Date ubegin) {
        Ubegin = ubegin;
    }

    public Date getUend() {
        return Uend;
    }

    public void setUend(Date uend) {
        Uend = uend;
    }
}
