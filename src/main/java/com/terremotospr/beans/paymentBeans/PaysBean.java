package com.terremotospr.beans.paymentBeans;

import java.util.Date;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
public class PaysBean {
    private Double changeAmount;
    private Date paymentDate;
    private Long paymentId;
    private Long orderId;

    public Date getPaymentDate() { return paymentDate; }

    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }

    public Long getPaymentId() { return paymentId; }

    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public Long getOrderId() { return orderId; }

    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public Double getChangeAmount() { return changeAmount; }

    public void setChangeAmount(Double changeAmount) { this.changeAmount = changeAmount; }
}

