package com.terremotospr.database.entities.administrativeEntities;

import java.io.Serializable;
import java.util.Objects;

public class SuppliesId implements Serializable {

    private Long supplierId;
    private Long resourceId;

    public Long getSupplierId() { return supplierId; }

    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }

    public Long getResourceId() { return resourceId; }

    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuppliesId that = (SuppliesId) o;
        return Objects.equals(supplierId, that.supplierId) &&
                Objects.equals(resourceId, that.resourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, resourceId);
    }
}
