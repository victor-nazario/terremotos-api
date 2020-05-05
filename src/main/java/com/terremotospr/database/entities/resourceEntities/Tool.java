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
    private String type;
    private double weight;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
