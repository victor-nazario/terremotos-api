package com.terremotospr.database.entities;

import java.io.Serializable;

public class PaysId implements Serializable {

    private Long paymentId;
    private Long orderId;

    public Long getPaymentId() { return paymentId; }

    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public Long getOrderId() { return orderId; }

    public void setOrderId(Long orderId) { this.orderId = orderId; }
}
