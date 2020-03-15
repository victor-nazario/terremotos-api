package com.terremotospr.database.entities;

import com.terremotospr.beans.dFoodType;

import javax.persistence.Entity;

@Entity
public class DryFood extends BaseResource {

    private String size;
    private dFoodType type;

    public dFoodType getType() { return type; }

    public void setType(dFoodType type) { this.type = type; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

}
