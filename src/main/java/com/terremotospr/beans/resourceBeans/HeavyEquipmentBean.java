package com.terremotospr.beans.resourceBeans;


/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */
public class HeavyEquipmentBean extends BaseResourceBean {

    private TypeofHeavyEquipment type;
    private Double size;

    public TypeofHeavyEquipment getType() { return type; }

    public void setType(TypeofHeavyEquipment type) { this.type = type; }

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }
}
