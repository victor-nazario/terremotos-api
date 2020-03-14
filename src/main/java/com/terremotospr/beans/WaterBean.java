package com.terremotospr.beans;

/**
 * Created on March 12, 2020 - 9:01 PM
 *
 * @author Victor Nazario
 */
public class WaterBean{

    private Long id;
    private typeOfWater type;
    private boolean potable;
    private int packagedQuantity;
    private String brand;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public typeOfWater getType() {
        return type;
    }

    public void setType(typeOfWater type) {
        this.type = type;
    }

    public boolean isPotable() {
        return potable;
    }

    public void setPotable(boolean potable) {
        this.potable = potable;
    }

    public int getPackagedQuantity() {
        return packagedQuantity;
    }

    public void setPackagedQuantity(int packagedQuantity) {
        this.packagedQuantity = packagedQuantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
