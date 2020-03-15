package com.terremotospr.database.entities;

import com.terremotospr.beans.dFoodType;

import javax.persistence.Entity;

@Entity
public class DryFood extends BaseResource {

    private String size;
    private dFoodType type;
    private String date = "MM/yyyy";

    public dFoodType getMedType() { return type; }

    public void setMedType(dFoodType type) { this.type = type; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public String getDateFormat() { return date; }

    public void setDateFormat(String date) { this.date = date; }

}
