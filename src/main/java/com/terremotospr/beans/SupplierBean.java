package com.terremotospr.beans;

import com.terremotospr.database.entities.Company;
import com.terremotospr.database.entities.User;

public class SupplierBean extends User {
    private String position;
    private Long comp_id;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getComp_id() {
        return comp_id;
    }

    public void setComp_id(Long comp_id) {
        this.comp_id = comp_id;
    }
}
