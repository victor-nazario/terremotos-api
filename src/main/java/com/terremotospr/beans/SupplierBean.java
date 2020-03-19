package com.terremotospr.beans;

import com.terremotospr.database.entities.User;

/*
 * @author Wilfredo Aponte Pomales
 */
public class SupplierBean extends User {
    private String position;
    private Long compId;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getCompId() { return compId; }

    public void setCompId(Long compId) { this.compId = compId; }
}
