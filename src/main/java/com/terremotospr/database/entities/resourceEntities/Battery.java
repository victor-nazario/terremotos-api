package com.terremotospr.database.entities.resourceEntities;

import com.terremotospr.beans.resourceBeans.BatteryType;
import com.terremotospr.database.entities.resourceEntities.BaseResource;

import javax.persistence.*;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Entity
public class Battery extends BaseResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long rId;

    private String type;
    private double size;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
