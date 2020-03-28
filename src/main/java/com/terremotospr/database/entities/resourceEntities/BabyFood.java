package com.terremotospr.database.entities.resourceEntities;

import com.terremotospr.beans.BabyFoodFlavor;

import javax.persistence.Entity;
/*
 * @author Wilfredo Aponte Pomales
 */
@Entity
public class BabyFood extends BaseResource {

    private String size;
    private BabyFoodFlavor flavor;

    public BabyFoodFlavor getMedType() { return flavor; }

    public void setMedType(BabyFoodFlavor flavor) { this.flavor = flavor; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

}
