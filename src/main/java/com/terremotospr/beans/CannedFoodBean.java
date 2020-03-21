package com.terremotospr.beans;


/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */
public class CannedFoodBean extends BaseResourceBean{

    private typeOfCannedFood type;
    private Double size;

    public typeOfCannedFood getType() { return type; }

    public void setType(typeOfCannedFood type) { this.type = type; }

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }
}
