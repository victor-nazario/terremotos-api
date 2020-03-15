package com.terremotospr.database.entities;

import com.terremotospr.beans.GasolineBean;
import com.terremotospr.beans.typeOfGasoline;
import com.terremotospr.beans.typeOfWater;

import javax.persistence.*;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/14/2020
 */

@Entity(name = "Gasoline")
public class Gasoline extends BaseResource{

    private typeOfGasoline type;
    private int octane;
    private int size;

    public typeOfGasoline getType() { return type; }

    public void setType(typeOfGasoline type) { this.type = type; }

    public int getOctane() { return octane; }

    public void setOctane(int octane) { this.octane = octane; }

    public int getSize() { return size; }

    public void setSize(int size) { this.size = size; }
}
