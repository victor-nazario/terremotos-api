package com.terremotospr.database.entities;

import com.terremotospr.beans.medicalDeviceType;

import javax.persistence.Entity;

@Entity
public class MedicalDevices extends BaseResource {

    private medicalDeviceType type;

    public medicalDeviceType getType() { return type; }

    public void setType(medicalDeviceType type) { this.type = type; }

}
