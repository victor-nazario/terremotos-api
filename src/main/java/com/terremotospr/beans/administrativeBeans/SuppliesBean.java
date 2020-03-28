package com.terremotospr.beans.administrativeBeans;

/*
 * @author Wilfredo Aponte Pomales
 */
public class SuppliesBean { ;
    private Long stock;
    private Long supplierId;
    private Long resourceId;

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getSupplierId() { return supplierId; }

    public void setSupplierId(Long supplierId) { this.supplierId = supplierId;}

    public Long getResourceId() { return resourceId; }

    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }
}
