package com.terremotospr.beans.resourceBeans;


/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */
public class CannedFoodBean extends BaseResourceBean {

    private String type;
    private Double size;

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }
}
