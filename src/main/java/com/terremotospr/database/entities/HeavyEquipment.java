package com.terremotospr.database.entities;

import com.terremotospr.beans.typeofHeavyEquipment;

import javax.persistence.Entity;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */
@Entity(name = "HeavyEquipment")
public class HeavyEquipment extends BaseResource{
    private typeofHeavyEquipment type;
    private Double size;

    public typeofHeavyEquipment getType() { return type; }

    public void setType(typeofHeavyEquipment type) { this.type = type; }

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }
}
