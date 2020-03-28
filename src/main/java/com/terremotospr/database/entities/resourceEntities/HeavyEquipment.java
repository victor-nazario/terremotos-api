package com.terremotospr.database.entities.resourceEntities;

import com.terremotospr.beans.resourceBeans.TypeofHeavyEquipment;

import javax.persistence.Entity;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */
@Entity(name = "HeavyEquipment")
public class HeavyEquipment extends BaseResource {
    private TypeofHeavyEquipment type;
    private Double size;

    public TypeofHeavyEquipment getType() { return type; }

    public void setType(TypeofHeavyEquipment type) { this.type = type; }

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }
}
