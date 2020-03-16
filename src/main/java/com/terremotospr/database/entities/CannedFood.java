package com.terremotospr.database.entities;

import com.terremotospr.beans.typeOfCannedFood;

import javax.persistence.Entity;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */
@Entity(name = "CannedFood")
public class CannedFood extends BaseResource{

    private typeOfCannedFood type;
    private Double size;

    public typeOfCannedFood getType() { return type; }

    public void setType(typeOfCannedFood type) { this.type = type; }

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }

}
