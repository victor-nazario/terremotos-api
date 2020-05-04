package com.terremotospr.database.entities.resourceEntities;

import com.terremotospr.beans.resourceBeans.FuelTypeGenerator;
import com.terremotospr.beans.resourceBeans.generatorType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/*
 * @author Wilfredo Aponte Pomales
 */
@Entity
public class PowerGen extends BaseResource {

    @Enumerated(EnumType.STRING)
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
