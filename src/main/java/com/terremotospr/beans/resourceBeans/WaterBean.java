package com.terremotospr.beans.resourceBeans;

/**
 * Created on March 12, 2020 - 9:01 PM
 *
 * @author Victor Nazario
 */
public class WaterBean extends BaseResourceBean {

    private boolean potable;
    private int packagedQuantity;
    private String type;

    public boolean isPotable() {
        return potable;
    }

    public void setPotable(boolean potable) {
        this.potable = potable;
    }

    public int getPackagedQuantity() { return packagedQuantity; }

    public void setPackagedQuantity(int packagedQuantity) { this.packagedQuantity = packagedQuantity; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }
}
