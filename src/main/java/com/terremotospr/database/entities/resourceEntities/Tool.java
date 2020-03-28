package com.terremotospr.database.entities.resourceEntities;

import com.terremotospr.beans.resourceBeans.ToolType;

import javax.persistence.Entity;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Entity
public class Tool extends BaseResource {
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
