package com.terremotospr.database.entities.resourceEntities;

import javax.persistence.Entity;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */
@Entity(name = "HeavyEquipment")
public class HeavyEquipment extends BaseResource {
    private String type;
    private Double size;

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }
}
