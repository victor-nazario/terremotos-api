package com.terremotospr.database.entities;

import com.terremotospr.beans.typeOfWater;

import javax.persistence.*;

/**
 * Created on March - -
 *
 * @author Victor Nazario
 */

@Entity(name = "Water")
public class Water extends BaseResource{

    private typeOfWater type;
    private boolean potable;
    private int packagedQuantity;

    public typeOfWater getType() {
        return type;
    }

    public void setType(typeOfWater type) {
        this.type = type;
    }

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

}
