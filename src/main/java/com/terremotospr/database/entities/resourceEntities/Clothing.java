package com.terremotospr.database.entities.resourceEntities;

import com.terremotospr.beans.ClothingType;
import com.terremotospr.beans.Gender;
import com.terremotospr.database.entities.resourceEntities.BaseResource;

import javax.persistence.Entity;

/*
 * @author Wilfredo Aponte
 */

@Entity
public class Clothing extends BaseResource {

    private String size;
    private String material;
    private ClothingType type;
    private Gender gender;

    public ClothingType getMedType() { return type; }

    public void setMedType(ClothingType type) { this.type = type; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public String getDosageForm() { return material; }

    public void setDosageForm(String material) { this.material = material; }

    public Gender getGender() { return gender; }

    public void setGender(Gender gender) { this.gender = gender; }
}
