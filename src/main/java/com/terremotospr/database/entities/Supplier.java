package com.terremotospr.database.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Supplier extends User {
//uid, comp-id, position

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "comp_id")
    private Company company;
    private String position;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) { this.company = company; }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
