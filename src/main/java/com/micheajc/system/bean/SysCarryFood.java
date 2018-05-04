package com.micheajc.system.bean;

public class SysCarryFood {

    private String foodname;
    private String foodshuliang;

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodshuliang() {
        return foodshuliang;
    }

    public void setFoodshuliang(String foodshuliang) {
        this.foodshuliang = foodshuliang;
    }

    public SysCarryFood() {

    }

    public SysCarryFood(String foodname, String foodshuliang) {

        this.foodname = foodname;
        this.foodshuliang = foodshuliang;
    }
}
