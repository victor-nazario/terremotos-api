package com.terremotospr.beans;

public class DryFoodBean extends BaseResourceBean {

    private Long id;
    private String size;
    private dFoodType type;
    private String date = "MM/yyyy";

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public dFoodType getMedType() { return type; }

    public void setMedType(dFoodType type) { this.type = type; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public String getDateFormat() { return date; }

    public void setDateFormat(String date) { this.date = date; }

}
