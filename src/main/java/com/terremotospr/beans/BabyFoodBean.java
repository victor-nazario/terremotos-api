package com.terremotospr.beans;

public class BabyFoodBean extends BaseResourceBean {

    private Long id;
    private String size;
    private babyFoodFlavor flavor;
    private String date;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public babyFoodFlavor getMedType() { return flavor; }

    public void setMedType(babyFoodFlavor flavor) { this.flavor = flavor; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public String getDateFormat() { return date; }

    public void setDateFormat(String date) { this.date = date; }

}
