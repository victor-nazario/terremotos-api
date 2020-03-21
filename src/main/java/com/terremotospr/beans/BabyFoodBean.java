package com.terremotospr.beans;

/*
 * @author Wilfredo Aponte Pomales
 */
public class BabyFoodBean extends BaseResourceBean {

    private Long id;
    private String size;
    private BabyFoodFlavor flavor;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public BabyFoodFlavor getFlavor() { return flavor; }

    public void setFlavor(BabyFoodFlavor flavor) { this.flavor = flavor; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

}
