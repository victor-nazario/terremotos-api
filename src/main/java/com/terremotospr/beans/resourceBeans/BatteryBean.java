package com.terremotospr.beans.resourceBeans;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
public class BatteryBean extends BaseResourceBean{
    private BatteryType type;
    private double size;

    public BatteryType getType() {
        return type;
    }

    public void setType(BatteryType type) {
        this.type = type;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
