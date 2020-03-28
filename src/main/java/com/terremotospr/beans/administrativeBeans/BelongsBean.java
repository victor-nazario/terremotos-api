package com.terremotospr.beans.administrativeBeans;

/*
 * @author Wilfredo Aponte Pomales
 */
public class BelongsBean {
    private Long orderId;
    private Long resourceId;
    private Long quantity;
    private Double finalPrice;

    public Long getOrderId() { return orderId; }

    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public Long getResourceId() { return resourceId; }

    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }

    public Long getQuantity() { return quantity; }

    public void setQuantity(Long quantity) { this.quantity = quantity; }

    public Double getFinalPrice() { return finalPrice; }

    public void setFinalPrice(Double finalPrice) { this.finalPrice = finalPrice; }
}
