package com.terremotospr.beans.resourceBeans;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/14/2020
 */
public class GasolineBean extends BaseResourceBean {

    private String type;
    private Double octane;
    private Double size;

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public Double getOctane() { return octane; }

    public void setOctane(Double octane) { this.octane = octane; }

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }
}