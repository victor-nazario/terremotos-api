package com.terremotospr.beans;

public class DryFoodBean extends BaseResourceBean {

    private Long id;
    private String size;
    private dFoodType type;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public dFoodType getType() { return type; }

    public void setType(dFoodType type) { this.type = type; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

}
