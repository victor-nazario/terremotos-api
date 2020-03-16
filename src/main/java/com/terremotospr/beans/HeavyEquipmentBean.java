package com.terremotospr.beans;


/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */
public class HeavyEquipmentBean extends BaseResourceBean{

    private typeofHeavyEquipment type;
    private Double size;

    public typeofHeavyEquipment getType() { return type; }

    public void setType(typeofHeavyEquipment type) { this.type = type; }

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }
}
