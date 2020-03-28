package com.terremotospr.database.entities.administrativeEntities;

import java.io.Serializable;

public class SuppliesId implements Serializable {

    private Long supplierId;
    private Long resourceId;

    public Long getSupplierId() { return supplierId; }

    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }

    public Long getResourceId() { return resourceId; }

    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }
}
