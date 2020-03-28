package com.terremotospr.database.entities.administrativeEntities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    private String cName;
    private String cLocation;


    @OneToMany(targetEntity=Supplier.class, mappedBy="company", orphanRemoval=true)
    private Set<Supplier> suppliers = new HashSet<>();

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcLocation() {
        return cLocation;
    }

    public void setcLocation(String cLocation) {
        this.cLocation = cLocation;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
