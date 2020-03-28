package com.terremotospr.database.entities.resourceEntities;

import com.terremotospr.beans.resourceBeans.DFoodType;

import javax.persistence.Entity;
/*
 * @author Wilfredo Aponte Pomales
 */
@Entity
public class DryFood extends BaseResource {

    private String size;
    private DFoodType type;

    public DFoodType getType() { return type; }

    public void setType(DFoodType type) { this.type = type; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

}
