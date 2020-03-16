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
    @JoinColumn(columnDefinition = "comp_id")
    private Company comp_id;
    private String position;

    public Company getComp_id() {
        return comp_id;
    }

    public void setComp_id(Company comp_id) {
        this.comp_id = comp_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
