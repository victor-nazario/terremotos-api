package com.terremotospr.database.entities.administrativeEntities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

//@Embeddable
public class BelongsId implements Serializable {
//    @Column(name = "order_id")
    private Long orderId;
//    @Column(name = "resource_id")
    private Long resourceId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BelongsId belongsId = (BelongsId) o;
        return Objects.equals(orderId, belongsId.orderId) &&
                Objects.equals(resourceId, belongsId.resourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, resourceId);
    }
}
