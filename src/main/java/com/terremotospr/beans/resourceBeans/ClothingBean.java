package com.terremotospr.beans.resourceBeans;

import com.terremotospr.beans.administrativeBeans.Gender;

/*
 * @author Wilfredo Aponte Pomales
 */
public class ClothingBean extends BaseResourceBean {

    private Long id;
    private String size;
    private String material;
    private ClothingType type;
    private Gender gender;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public ClothingType getMedType() { return type; }

    public void setMedType(ClothingType type) { this.type = type; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public String getDosageForm() { return material; }

    public void setDosageForm(String material) { this.material = material; }

    public Gender getGender() { return gender; }

    public void setGender(Gender gender) { this.gender = gender; }

}
