package com.terremotospr.database.entities.resourceEntities;

import javax.persistence.Entity;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/14/2020
 */

@Entity(name = "Gasoline")
public class Gasoline extends Fuel {

    private String  gasolinetType;
    private Double octane;
    private Double size;

    public String  getType() { return gasolinetType; }

    public void setType(String gasolineType) { this.gasolinetType = gasolineType; }

    public Double getOctane() { return octane; }

    public void setOctane(Double octane) { this.octane = octane; }

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }
}
