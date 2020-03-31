package com.terremotospr.database.entities.resourceEntities;

import com.terremotospr.beans.resourceBeans.ClothingType;
import com.terremotospr.beans.resourceBeans.ClothesGender;

import javax.persistence.Entity;

/*
 * @author Wilfredo Aponte
 */

@Entity
public class Clothing extends BaseResource {

    private String size;
    private String material;
    private ClothingType type;
    private ClothesGender gender;

    public ClothingType getMedType() { return type; }

    public void setMedType(ClothingType type) { this.type = type; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public String getDosageForm() { return material; }

    public void setDosageForm(String material) { this.material = material; }

    public ClothesGender getGender() { return gender; }

    public void setGender(ClothesGender gender) { this.gender = gender; }
}
