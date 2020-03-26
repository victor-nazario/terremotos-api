package com.terremotospr.beans;

import java.util.Date;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
public class PaysBean {
    private Date paymentDate;
    private Long paymentId;
    private Long orderId;

    public Date getPaymentDate() { return paymentDate; }

    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }

    public Long getPaymentId() { return paymentId; }

    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public Long getOrderId() { return orderId; }

    public void setOrderId(Long orderId) { this.orderId = orderId; }
}

