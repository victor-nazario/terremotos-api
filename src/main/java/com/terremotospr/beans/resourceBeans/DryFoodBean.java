package com.terremotospr.beans.resourceBeans;

/*
 * @author Wilfredo Aponte Pomales
 */
public class DryFoodBean extends BaseResourceBean {

    private Long id;
    private String size;
    private DFoodType type;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public DFoodType getType() { return type; }

    public void setType(DFoodType type) { this.type = type; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

}
