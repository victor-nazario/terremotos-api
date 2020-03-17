package com.terremotospr.database.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
public class Supplier extends User {
//uid, comp-id, position

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="comp_id", referencedColumnName = "comp_id")
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
