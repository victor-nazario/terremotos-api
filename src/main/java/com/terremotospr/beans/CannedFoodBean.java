package com.terremotospr.beans;


/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */
public class CannedFoodBean extends BaseResourceBean{

    private TypeOfCannedFood type;
    private Double size;

    public TypeOfCannedFood getType() { return type; }

    public void setType(TypeOfCannedFood type) { this.type = type; }

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }
}
