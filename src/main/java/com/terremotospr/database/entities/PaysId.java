package com.terremotospr.database.entities;

import java.io.Serializable;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/26/2020
 */
public class PaysId implements Serializable {

    private Long paymentId;
    private Long orderId;

    public Long getPaymentId() { return paymentId; }

    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public Long getOrderId() { return orderId; }

    public void setOrderId(Long orderId) { this.orderId = orderId; }
}
