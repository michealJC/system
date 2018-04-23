package com.micheajc.system.bean;

public class sys_foodshop {

    private String image;
    private String foodname;
    private String foodjiage;
    private String foodshuliang;



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

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

    public sys_foodshop(String image, String foodname, String foodjiage, String foodshuliang) {

        this.image = image;
        this.foodname = foodname;
        this.foodjiage = foodjiage;
        this.foodshuliang = foodshuliang;
    }

    public sys_foodshop() {

    }
}
