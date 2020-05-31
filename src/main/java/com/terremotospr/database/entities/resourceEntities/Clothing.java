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

    public ClothingType getClothingType() { return type; }

    public void setClothingType(ClothingType type) { this.type = type; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public String getMaterial() { return material; }

    public void setMaterial(String material) { this.material = material; }

    public ClothesGender getGender() { return gender; }

    public void setGender(ClothesGender gender) { this.gender = gender; }
}
