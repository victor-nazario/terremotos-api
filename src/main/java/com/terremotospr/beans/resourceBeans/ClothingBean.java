package com.terremotospr.beans.resourceBeans;

/*
 * @author Wilfredo Aponte Pomales
 */
public class ClothingBean extends BaseResourceBean {

    private Long id;
    private String size;
    private String material;
    private ClothingType type;
    private ClothesGender gender;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public ClothingType getClothingType() { return type; }

    public void setClothingType(ClothingType type) { this.type = type; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public String getMaterial() { return material; }

    public void setMaterial(String material) { this.material = material; }

    public ClothesGender getGender() { return gender; }

    public void setGender(ClothesGender gender) { this.gender = gender; }

}
