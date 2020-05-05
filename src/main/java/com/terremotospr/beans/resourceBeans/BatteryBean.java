package com.terremotospr.beans.resourceBeans;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
public class BatteryBean extends BaseResourceBean{
    private String type;
    private double size;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
