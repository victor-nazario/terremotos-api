package com.terremotospr.database.entities;

import com.terremotospr.beans.babyFoodFlavor;

public class BabyFood extends BaseResource {

    private String size;
    private babyFoodFlavor flavor;
    private String date;

    public babyFoodFlavor getMedType() { return flavor; }

    public void setMedType(babyFoodFlavor flavor) { this.flavor = flavor; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public String getDateFormat() { return date; }

    public void setDateFormat(String date) { this.date = date; }


}
