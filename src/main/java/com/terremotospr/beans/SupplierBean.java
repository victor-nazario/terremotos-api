package com.terremotospr.beans;

import com.terremotospr.database.entities.User;

public class SupplierBean extends User {
    private CompanyBean company;
    private String position;

    public CompanyBean getCompany() {
        return company;
    }

    public void setCompany(CompanyBean company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
