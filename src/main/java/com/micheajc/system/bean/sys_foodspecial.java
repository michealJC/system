package com.micheajc.system.bean;



public class sys_foodspecial {

    private  int id;
    //今日特价的名称
    private String foodspecialname;
    //今日特价的图片
    private String foodspecialimage;
    //今日特价的价格
    private int foodspecialjiage;
    //今日特价的描述
    private String foodspecialmiaoshu;
    //今日特价的分类
    private String foodspecialclass;

    public sys_foodspecial(int id, String foodspecialname, String foodspecialimage, int foodspecialjiage, String foodspecialmiaoshu, String foodspecialclass) {
        this.id = id;
        this.foodspecialname = foodspecialname;
        this.foodspecialimage = foodspecialimage;
        this.foodspecialjiage = foodspecialjiage;
        this.foodspecialmiaoshu = foodspecialmiaoshu;
        this.foodspecialclass = foodspecialclass;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodspecialname() {
        return foodspecialname;
    }

    public void setFoodspecialname(String foodspecialname) {
        this.foodspecialname = foodspecialname;
    }

    public String getFoodspecialimage() {
        return foodspecialimage;
    }

    public void setFoodspecialimage(String foodspecialimage) {
        this.foodspecialimage = foodspecialimage;
    }

    public int getFoodspecialjiage() {
        return foodspecialjiage;
    }

    public void setFoodspecialjiage(int foodspecialjiage) {
        this.foodspecialjiage = foodspecialjiage;
    }

    public String getFoodspecialmiaoshu() {
        return foodspecialmiaoshu;
    }

    public void setFoodspecialmiaoshu(String foodspecialmiaoshu) {
        this.foodspecialmiaoshu = foodspecialmiaoshu;
    }

    public String getFoodspecialclass() {
        return foodspecialclass;
    }

    public void setFoodspecialclass(String foodspecialclass) {
        this.foodspecialclass = foodspecialclass;
    }
}
