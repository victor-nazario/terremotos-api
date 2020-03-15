package com.terremotospr.database.entities;

import javax.persistence.Entity;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */
@Entity(name = "SmallBottle")
public class SmallBottle extends Water {

    private Double size;

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }
}
