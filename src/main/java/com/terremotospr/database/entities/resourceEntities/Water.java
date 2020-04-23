package com.terremotospr.database.entities.resourceEntities;

import com.terremotospr.beans.resourceBeans.TypeOfWater;

import javax.persistence.Entity;

/**
 * Created on March - -
 *
 * @author Victor Nazario
 */

@Entity(name = "Water")
public class Water extends BaseResource {

    private boolean potable;
    private int packagedQuantity;
    private TypeOfWater type;

    public boolean isPotable() {
        return potable;
    }

    public void setPotable(boolean potable) {
        this.potable = potable;
    }

    public int getPackagedQuantity() {
        return packagedQuantity;
    }

    public void setPackagedQuantity(int packagedQuantity) {
        this.packagedQuantity = packagedQuantity;
    }

    public TypeOfWater getType() { return type; }

    public void setType(TypeOfWater type) { this.type = type; }
}
