package com.terremotospr.database.entities.administrativeEntities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

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
}
