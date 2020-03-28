package com.terremotospr.database.entities.resourceEntities;

import com.terremotospr.database.entities.resourceEntities.BaseResource;

import javax.persistence.Entity;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@Entity(name = "Ice")
public class Ice extends BaseResource {

    private Double size;

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }
}
