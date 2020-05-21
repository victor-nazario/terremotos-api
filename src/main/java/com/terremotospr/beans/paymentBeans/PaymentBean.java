package com.terremotospr.beans.paymentBeans;

/**
 * @author Kiara Rodriguez Rojas
 * date 03/19/2020
 */
public class PaymentBean {

    private Long paymentId;
    private Long consumerId;
    private Double amountPaid;

    public Long getPaymentId() { return paymentId; }

    public void setPaymentId(Long payment_id) { this.paymentId = payment_id; }

    public Double getAmountPaid() { return amountPaid; }

    public void setAmountPaid(Double amountPaid) { this.amountPaid = amountPaid; }

    public Long getConsumerId() { return consumerId; }

    public void setConsumerId(Long consumerId) { this.consumerId = consumerId; }
}
