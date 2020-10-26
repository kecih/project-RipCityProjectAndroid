package com.example.ripcity.ui.main.ui;

public class UserHelperClass {
    String id, versus, tanggal, time;

    public UserHelperClass() {
    }

    public UserHelperClass(String Id, String Versus, String Tanggal, String Time) {
        id = Id;
        versus = Versus;
        tanggal = Tanggal;
        time = Time;
    }

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }

    public String getVersus() {
        return versus;
    }

    public void setVersus(String Versus) {
        this.versus = Versus;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String Tanggal) {
        this.tanggal = Tanggal;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String Time) {
        this.time = Time;
    }
}
