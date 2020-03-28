package com.terremotospr.database.entities.resourceEntities;

import com.terremotospr.beans.TypeOfCannedFood;
import com.terremotospr.database.entities.resourceEntities.BaseResource;

import javax.persistence.Entity;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */
@Entity(name = "CannedFood")
public class CannedFood extends BaseResource {

    private TypeOfCannedFood type;
    private Double size;

    public TypeOfCannedFood getType() { return type; }

    public void setType(TypeOfCannedFood type) { this.type = type; }

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }

}
