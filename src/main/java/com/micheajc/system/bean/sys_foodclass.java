package com.micheajc.system.bean;

public class sys_foodclass {
    private int id;
    private String foodclass_name;



    public sys_foodclass(int id, String foodclass_name) {
        this.id = id;
        this.foodclass_name = foodclass_name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getFoodclass_name() {
        return foodclass_name;
    }

    public void setFoodclass_name(String foodclass_name) {
        this.foodclass_name = foodclass_name;
    }
}
