package com.terremotospr.beans;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/14/2020
 */
public class GasolineBean extends BaseResourceBean{

    private typeOfGasoline type;
    private Double octane;
    private Double size;

    public typeOfGasoline getType() { return type; }

    public void setType(typeOfGasoline type) { this.type = type; }

    public Double getOctane() { return octane; }

    public void setOctane(Double octane) { this.octane = octane; }

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }
}