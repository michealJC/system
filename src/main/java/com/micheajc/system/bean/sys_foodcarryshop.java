package com.micheajc.system.bean;

public class sys_foodcarryshop {

    private String foodname;
    private String foodjiage;
    private String foodshuliang;
    private String foodzuohao;


    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodjiage() {
        return foodjiage;
    }

    public void setFoodjiage(String foodjiage) {
        this.foodjiage = foodjiage;
    }

    public String getFoodshuliang() {
        return foodshuliang;
    }

    public void setFoodshuliang(String foodshuliang) {
        this.foodshuliang = foodshuliang;
    }

    public String getFoodzuohao() {
        return foodzuohao;
    }

    public void setFoodzuohao(String foodzuohao) {
        this.foodzuohao = foodzuohao;
    }

    public sys_foodcarryshop( String foodname, String foodjiage, String foodshuliang, String foodzuohao) {

        this.foodname = foodname;
        this.foodjiage = foodjiage;
        this.foodshuliang = foodshuliang;
        this.foodzuohao = foodzuohao;
    }

    public sys_foodcarryshop() {

    }
}
