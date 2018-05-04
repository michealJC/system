package com.micheajc.system.bean;

public class SysMenuTable {

    private int renshu;
    private int addjine;
    private int id;
    private String data;

    public int getRenshu() {
        return renshu;
    }

    public void setRenshu(int renshu) {
        this.renshu = renshu;
    }

    public int getAddjine() {
        return addjine;
    }

    public void setAddjine(int addjine) {
        this.addjine = addjine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public SysMenuTable(int renshu, int addjine, int id, String data) {

        this.renshu = renshu;
        this.addjine = addjine;
        this.id = id;
        this.data = data;
    }

    public SysMenuTable() {

    }
}
