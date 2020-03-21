package com.terremotospr.database.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Supplier extends User {
//uid, comp-id, position

    @ManyToOne(targetEntity = Company.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "comp_id", insertable = false, updatable = false)
    private Company company;


    @Column(name = "comp_id")
    private Long compId;

    @OneToMany(targetEntity=Supplies.class, mappedBy="supplier", cascade={CascadeType.ALL}, orphanRemoval=true)
    private Set<Supplies> supplies = new HashSet<>();

    private String position;
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }
}
