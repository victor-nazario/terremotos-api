package com.terremotospr.beans.resourceBeans;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Victor Nazario
 */
public class FuelBean extends BaseResourceBean {
    @JsonIgnore
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
