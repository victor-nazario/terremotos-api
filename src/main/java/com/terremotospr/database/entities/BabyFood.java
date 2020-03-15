package com.terremotospr.database.entities;

import com.terremotospr.beans.babyFoodFlavor;

import javax.persistence.Entity;

@Entity
public class BabyFood extends BaseResource {

    private String size;
    private babyFoodFlavor flavor;

    public babyFoodFlavor getMedType() { return flavor; }

    public void setMedType(babyFoodFlavor flavor) { this.flavor = flavor; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

}
