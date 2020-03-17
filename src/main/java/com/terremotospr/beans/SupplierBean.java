package com.terremotospr.beans;

import com.terremotospr.database.entities.Company;
import com.terremotospr.database.entities.User;

public class SupplierBean extends User {
    private String position;
    private Company company;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
