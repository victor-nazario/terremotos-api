package com.terremotospr.beans;

/*
 * @author Wilfredo Aponte Pomales
 */
public class SuppliesBean {
    private Long id;
    private Long stock;
    private SupplierBean supplier;
    private BaseResourceBean resource;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public SupplierBean getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierBean supplier) {
        this.supplier = supplier;
    }

    public BaseResourceBean getResource() {
        return resource;
    }

    public void setResource(BaseResourceBean resource) {
        this.resource = resource;
    }
}
