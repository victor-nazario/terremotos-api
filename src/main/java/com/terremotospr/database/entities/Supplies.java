package com.terremotospr.database.entities;

import javax.persistence.Entity;
import javax.persistence.*;

/*
 * @author Wilfredo Aponte Pomales
 */
@Entity
@IdClass(SuppliesId.class)
public class Supplies {
    @Id
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    Supplier supplier;

    @Column(name = "supplier_id")
    private Long supplierId;

    @Id
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "resource_id", insertable = false, updatable = false)
    BaseResource resource;

    @Column(name = "resource_id")
    private Long resourceId;

    private Long stock;

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

    public Long getSupplierId() { return supplierId; }

    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }

    public Long getResourceId() { return resourceId; }

    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }
}
