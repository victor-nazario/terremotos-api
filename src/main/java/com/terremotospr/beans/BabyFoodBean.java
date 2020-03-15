package com.terremotospr.beans;

public class BabyFoodBean extends BaseResourceBean {

    private Long id;
    private String size;
    private babyFoodFlavor flavor;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public babyFoodFlavor getFlavor() { return flavor; }

    public void setFlavor(babyFoodFlavor flavor) { this.flavor = flavor; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

}
