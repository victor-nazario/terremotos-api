package com.terremotospr.beans;

import com.terremotospr.database.entities.User;

public class SupplierBean extends User {
    private String position;
    private CompanyBean company;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public CompanyBean getCompany() { return company; }

    public void setCompany(CompanyBean company) { this.company = company; }
}
