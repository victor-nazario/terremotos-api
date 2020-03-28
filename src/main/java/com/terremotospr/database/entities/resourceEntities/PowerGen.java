package com.terremotospr.database.entities.resourceEntities;

import com.terremotospr.beans.FuelTypeGenerator;
import com.terremotospr.beans.generatorType;
import com.terremotospr.database.entities.resourceEntities.BaseResource;

import javax.persistence.Entity;
/*
 * @author Wilfredo Aponte Pomales
 */
@Entity
public class PowerGen extends BaseResource {

    private generatorType type;
    private String power;
    private FuelTypeGenerator fuelType;

    public generatorType getType() { return type; }

    public void setType(generatorType type) { this.type = type;}

    public String getPower() { return power;}

    public void setPower(String power) { this.power = power; }

    public FuelTypeGenerator getFuelType() { return fuelType; }

    public void setFuelType(FuelTypeGenerator fuelType) { this.fuelType = fuelType; }
}
