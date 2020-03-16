package com.terremotospr.beans;

public class MedicalDevicesBean extends  BaseResourceBean {

    private Long id;
    private medicalDeviceType type;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public medicalDeviceType getType() { return type; }

    public void setType(medicalDeviceType type) { this.type = type; }

}
