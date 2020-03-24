package com.terremotospr.database.entities;

import javax.persistence.*;
import java.io.Serializable;

/*
 * @author Wilfredo Aponte Pomales
 */
@Entity
@IdClass(BelongsId.class)
public class Belongs implements Serializable {

    @Id
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    PlacedOrder orders;

    @Column(name = "order_id")
    private Long orderId;

    @Id
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "resource_id", insertable = false, updatable = false)
    BaseResource resource;

    @Column(name = "resource_id")
    private Long resourceId;

    private Long quantity;
    private Double finalPrice;

    public Long getQuantity() { return quantity; }

    public void setQuantity(Long quantity) { this.quantity = quantity; }

    public Double getFinalPrice() { return finalPrice; }

    public void setFinalPrice(Double finalPrice) { this.finalPrice = finalPrice; }

    public PlacedOrder getOrders() { return orders; }

    public void setOrders(PlacedOrder orders) { this.orders = orders; }

    public Long getOrderId() { return orderId;}

    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public BaseResource getResources() { return resource; }

    public void setResources(BaseResource resource) { this.resource = resource; }

    public Long getResourceId() { return resourceId; }

    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }

}
