package com.terremotospr.database.entities.resourceEntities;

import com.terremotospr.beans.resourceBeans.FuelTypeGenerator;
import com.terremotospr.beans.resourceBeans.PowerGeneratorType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/*
 * @author Wilfredo Aponte Pomales
 */
@Entity
public class PowerGen extends BaseResource {

    @Enumerated(EnumType.STRING)
    private PowerGeneratorType type;
    private String power;
    private FuelTypeGenerator fuelType;

    public PowerGeneratorType getType() { return type; }

    public void setType(PowerGeneratorType type) { this.type = type;}

    public String getPower() { return power;}

    public void setPower(String power) { this.power = power; }

    public FuelTypeGenerator getFuelType() { return fuelType; }

    public void setFuelType(FuelTypeGenerator fuelType) { this.fuelType = fuelType; }
}
