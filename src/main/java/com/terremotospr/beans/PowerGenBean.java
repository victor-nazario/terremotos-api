package com.terremotospr.beans;
/*
 * @author Wilfredo Aponte Pomales
 */
public class PowerGenBean extends BaseResourceBean {
    private Long id;
    private generatorType type;
    private String power;
    private FuelTypeGenerator fuelType;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public generatorType getType() { return type; }

    public void setType(generatorType type) { this.type = type;}

    public String getPower() { return power;}

    public void setPower(String power) { this.power = power; }

    public FuelTypeGenerator getFuelType() { return fuelType; }

    public void setFuelType(FuelTypeGenerator fuelType) { this.fuelType = fuelType; }
}
