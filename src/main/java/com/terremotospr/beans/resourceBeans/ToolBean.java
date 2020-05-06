package com.terremotospr.beans.resourceBeans;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
public class ToolBean extends BaseResourceBean {
    private String type;
    private double weight;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
