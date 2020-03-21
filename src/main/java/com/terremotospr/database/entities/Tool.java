package com.terremotospr.database.entities;

import com.terremotospr.beans.ToolType;

import javax.persistence.Entity;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Entity
public class Tool extends BaseResource{
    private ToolType type;
    private double weight;

    public ToolType getType() {
        return type;
    }

    public void setType(ToolType type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
