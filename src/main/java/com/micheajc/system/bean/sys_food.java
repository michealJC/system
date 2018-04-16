package com.micheajc.system.bean;

public class sys_food {
    private int id;
    private String food_name;
    private int food_jiage;
    private String food_miaoshu;
    private String food_image;
    private String food_foodclass;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public int getFood_jiage() {
        return food_jiage;
    }

    public void setFood_jiage(int food_jiage) {
        this.food_jiage = food_jiage;
    }

    public String getFood_miaoshu() {
        return food_miaoshu;
    }

    public void setFood_miaoshu(String food_miaoshu) {
        this.food_miaoshu = food_miaoshu;
    }

    public String getFood_image() {
        return food_image;
    }

    public void setFood_image(String food_image) {
        this.food_image = food_image;
    }

    public String getFood_foodclass() {
        return food_foodclass;
    }

    public void setFood_foodclass(String food_foodclass) {
        this.food_foodclass = food_foodclass;
    }

    public sys_food(int id, String food_name, int food_jiage, String food_miaoshu, String food_image, String food_foodclass) {

        this.id = id;
        this.food_name = food_name;
        this.food_jiage = food_jiage;
        this.food_miaoshu = food_miaoshu;
        this.food_image = food_image;
        this.food_foodclass = food_foodclass;
    }
}
