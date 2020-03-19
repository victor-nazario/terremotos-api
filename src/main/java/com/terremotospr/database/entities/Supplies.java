package com.terremotospr.database.entities;

import javax.persistence.Entity;
import javax.persistence.*;

/*
 * @author Wilfredo Aponte Pomales
 */
@Entity
public class Supplies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    Supplier supplier;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "resource_id")
    BaseResource resource;

    private Long stock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public BaseResource getResource() {
        return resource;
    }

    public void setResource(BaseResource resource) {
        this.resource = resource;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
