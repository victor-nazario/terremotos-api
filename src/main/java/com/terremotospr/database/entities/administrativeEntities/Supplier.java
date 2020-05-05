package com.terremotospr.database.entities.administrativeEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","supplies"})
public class Supplier extends User {
//uid, comp-id, position

    @JsonIgnore
    @ManyToOne(targetEntity = Company.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "comp_id", insertable = false, updatable = false)
    private Company company;


    @Column(name = "comp_id")
    private Long compId;

    @JsonIgnore
    @OneToMany(targetEntity=Supplies.class, mappedBy="supplier",fetch = FetchType.LAZY,cascade={CascadeType.ALL}, orphanRemoval=true)
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
