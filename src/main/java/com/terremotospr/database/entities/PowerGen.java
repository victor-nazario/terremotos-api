package com.terremotospr.database.entities;

import com.terremotospr.beans.fuelTypeGenerator;
import com.terremotospr.beans.generatorType;

import javax.persistence.Entity;

@Entity
public class PowerGen extends BaseResource {

    private generatorType type;
    private String power;
    private fuelTypeGenerator fuelType;

    public generatorType getType() { return type; }

    public void setType(generatorType type) { this.type = type;}

    public String getPower() { return power;}

    public void setPower(String power) { this.power = power; }

    public fuelTypeGenerator getFuelType() { return fuelType; }

    public void setFuelType(fuelTypeGenerator fuelType) { this.fuelType = fuelType; }
}
